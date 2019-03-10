package upc.arqsoft.dbs;

import upc.arqsoft.dbs.dao.FineDAO;
import upc.arqsoft.dbs.dao.JDBCFineDAO;
import upc.arqsoft.dbs.model.Fine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Random;

// Very simple app that you can use as a template for your future developments
public class App {

    private static final Random RND = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws Exception {
        // This sentence allows using the H2 JDBC driver. If you want to use other database engine
        // you will need to change this
        Class.forName("org.h2.Driver");

        DbManager db = new DbManager("jdbc:h2:~/my-db-template", "sa", "");

        System.out.println("Starting the database....");
        db.startService();

        System.out.println("Connecting to the database...");
        Connection conn = db.getConnection();
        try {
            System.out.println("Creating the database tables, if they don't exist");

            // The "IF NOT EXIST" clause avoids trying to recreate the table each time the application
            // is started
            PreparedStatement pstmt = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS Fines (" +
                            "id INT PRIMARY KEY AUTO_INCREMENT," +
                            "model VARCHAR(256), " +
                            "licensePlate VARCHAR(16) NOT NULL, " +
                            "euros INT NOT NULL," +
                            "paid BOOLEAN DEFAULT FALSE);");
            pstmt.executeUpdate();

            FineDAO dao = new JDBCFineDAO(conn);

            String car = randomModel();
            String plate = randomPlate();
            System.out.println("generating some fines for the " + randomModel() + " with plate " + plate);
            for (int i = 0; i < 10; i++) {
                dao.addFine(car, plate, 1 + RND.nextInt(100));
            }

            System.out.println("listing all the fines for car with plate " + plate);
            List<Fine> fines = dao.getAllFines(plate);
            for (Fine f : fines) {
                System.out.println(f);
            }

            System.out.println("paying some random fines");
            for (Fine f : fines) {
                f.setPaid(RND.nextBoolean());
                dao.updateFine(f);
            }

            System.out.println("listing the updated list if the fines for car with plate " + plate);
            // functional alternative to the previous for
            dao.getAllFines(plate).forEach(System.out::println);

        } finally {
            // we must close the database connection at the end
            if (conn != null) {
                conn.close();
            }
            db.stop();
        }
    }


    /**
     * Generates a random car plate
     */
    static String randomPlate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append((char) ('0' + RND.nextInt(10)));
        }
        sb.append('-');
        for (int i = 0; i < 3; i++) {
            sb.append((char) ('A' + RND.nextInt('Z' - 'A')));
        }
        return sb.toString();
    }

    /**
     * Generates a random car model
     */
    static String randomModel() {
        String[] brands = {"Tesuka", "Marxwell", "Trini", "Chorrus", "Tranks"};
        String[] models = {"Fews", "Plus", "Tras", "Traska", "Forls", "Jarls"};

        return brands[RND.nextInt(brands.length)] + " "
                + models[RND.nextInt(models.length)];
    }
}
