package upc.arqsoft.dbs;

import org.h2.tools.Server;

public class App {

    public static void main(String[] args) throws Exception {
        // This line will run the H2 Server. Open http://localhost:8080 in your browser to see it
        Server server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8080", "-ifNotExists");
        server.start();

        System.out.println("Running H2 Database in server mode...");
        System.out.println("\nHOW TO inspect the database while this app is running:");
        System.out.println("\t- Open http://localhost:8080 (or any other database tool)");
        System.out.println("\t- Make sure the Login form has the following values:");
        System.out.println("\t\tSaved settings: Generic H2 (Embedded)");
        System.out.println("\t\tDriver Class: org.h2.Driver");
        System.out.println("\t\tJDBC URL: jdbc:h2:~/sql-example");
        System.out.println("\t\tUser Name: sa");
        System.out.println("\t\tPassword: (leave it empty)");

    }
}
