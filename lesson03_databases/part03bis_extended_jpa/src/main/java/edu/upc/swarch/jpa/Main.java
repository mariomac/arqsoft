package edu.upc.swarch.jpa;

import edu.upc.swarch.jpa.entities.Author;
import edu.upc.swarch.jpa.entities.Film;
import edu.upc.swarch.jpa.entities.Genre;
import org.h2.tools.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) throws Exception {
        // The following two lines disable the annoying console logging from hibernate
        @SuppressWarnings("unused") org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE); //or whatever level you need

        // start the TCP Server for debugging. Open http://localhost:8080 in your browser to see it
        Server server = Server.createWebServer("-web","-webAllowOthers","-webPort","8080");
        try {
            server.start();

            // Start the Films DAO and populating the database
            System.out.println("Populating the database....");

            FilmsDAO dao = new FilmsDAO();

            Genre fantasy = new Genre("Fantasy");
            dao.store(fantasy);
            Genre terror = new Genre("Terror");
            dao.store(terror);


            // Let's add Akira Kurosawa and its filmography
            Author author = new Author("Akira Kurosawa");
            dao.store(author);
            dao.store(new Film("The Bad Sleep Well", 1960, author, fantasy));
            dao.store(new Film("Dersu Uzala", 1975, author, terror));
            dao.store(new Film("Dreams", 1990, author, fantasy));

            // Let's add Pedro Almodovar and its filmography
            author = new Author("Pedro Almodovar");
            dao.store(author);
            dao.store(new Film("Labyrinth of Passion", 1982, author, terror));
            dao.store(new Film("Kika", 1993, author,fantasy));

            System.out.println("\nQuerying all the registered films");
            System.out.println("=================================");
            dao.findAll().forEach(System.out::println);

            System.out.println("\nGetting all the films between 1970 and 1990");
            System.out.println("===========================================");
            dao.findByYearRange(1970, 1990).forEach(System.out::println);

            System.out.println("\nHOW TO inspect the database while this app is running:");
            System.out.println("\t- Open http://localhost:8080");
            System.out.println("\t- Make sure the Login form has the following values:");
            System.out.println("\t\tSaved settings: Generic H2 (Embedded)");
            System.out.println("\t\tDriver Class: org.h2.Driver");
            System.out.println("\t\tJDBC URL: jdbc:h2:~/jpa-example");
            System.out.println("\t\tUser Name: sa");
            System.out.println("\t\tPassword: (leave it empty)");

            System.out.println("\nPress ENTER to exit");
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } finally {
            server.stop();
            System.exit(0);
        }
    }
}
