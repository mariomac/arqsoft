package upc.arqsoft.dbs.dao;

import upc.arqsoft.dbs.model.Fine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the FineDAO that uses Java Database Connection (JDBC) API to submit SQL
 * queries and updates to an SQL connection.
 */
public class JDBCFineDAO implements FineDAO {

    private Connection connection;

    public JDBCFineDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFine(String model, String plate, int euros) throws Exception {

        // Prepare an INSERT INTO statement. The ? are placeholders to set later, programmatically,
        // the values to be inserted
        // DANGER!! NEVER NEVER set the values directly in the statement string, or your application
        // will suffer a nice SQL injection hacker attack
        PreparedStatement s = connection.prepareStatement(
                "INSERT INTO Fines(model, licensePlate, euros, paid) " +
                        "VALUES (?, ?, ?, false);");

        // Set the user-provided values to be inserted. NOTICE that parameter indices start with 1, not 0
        s.setString(1, model);
        s.setString(2, plate);
        s.setInt(3, euros);

        // execute the statement: executeUpdate() because this commands updates the data
        s.executeUpdate();

        // close the statement to release JDBC resources
        s.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateFine(Fine fine) throws Exception {
        // Prepare an UPDATE statement. The ? are placeholders to set later, programmatically,
        // the values to be inserted
        // DANGER!! NEVER NEVER set the values directly in the statement string, or your application
        // will suffer a nice SQL injection hacker attack
        PreparedStatement s = connection.prepareStatement(
                "UPDATE Fines " +
                        "SET model = ?, licensePlate = ?, euros = ?, paid = ? " +
                        "WHERE id = ?;");

        // Set the user-provided values to be inserted. NOTICE that parameter indices start with 1, not 0
        s.setString(1, fine.getModel());
        s.setString(2, fine.getPlate());
        s.setInt(3, fine.getEuros());
        s.setBoolean(4, fine.isPaid());
        s.setInt(5, fine.getId());

        // execute the statement: executeUpdate() because this commands updates the data
        s.executeUpdate();

        // close the statement to release JDBC resources
        s.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Fine> getAllFines(String plate) throws Exception {
        List<Fine> fines = new ArrayList<>();

        // Prepare a SELECT statement
        PreparedStatement s = connection.prepareStatement(
                "SELECT id, model, euros, paid FROM Fines WHERE licensePlate = ?;");

        s.setString(1, plate);

        // executes the statement: executeQuery because this command retrieves data
        ResultSet rs = s.executeQuery();

        // while the returned result set has elements
        while (rs.next()) {
            // we load the returned values from each row
            int id = rs.getInt(1);
            String model = rs.getString(2);
            int euros = rs.getInt(3);
            boolean paid = rs.getBoolean(4);

            // and create a java object from it
            fines.add(new Fine(id, model, plate, euros, paid));
        }

        // close the statement to release JDBC resources
        s.close();

        return fines;
    }
}
