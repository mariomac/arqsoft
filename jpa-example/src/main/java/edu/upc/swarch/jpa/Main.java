package edu.upc.swarch.jpa;

import edu.upc.swarch.jpa.entities.Author;
import edu.upc.swarch.jpa.entities.Film;
import org.h2.tools.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        // start the TCP Server for debugging. Open http://localhost:8080 in your browser to see it
        Server server = Server.createWebServer("-web","-webAllowOthers","-webPort","8080");

        try {
            server.start();

            // Start the Films DAO and populating the database

            System.out.println("Populating the database....");

            FilmsDAO dao = new FilmsDAO();

            Author author = new Author("Akira Kurosawa");
            dao.store(author);

            dao.store(new Film("The Bad Sleep Well", 1960, author));
            dao.store(new Film("Dersu Uzala", 1975, author));
            dao.store(new Film("Dreams", 1990, author));

            author = new Author("Pedro Almodovar");
            dao.store(author);

            dao.store(new Film("Labyrinth of Passion", 1982, author));
            dao.store(new Film("Kika", 1993, author));

            System.out.println("Querying all the registered films");
            dao.findAll().forEach(System.out::println);

            System.out.println("Getting all the films between 1970 and 1990");
            dao.findByYearRange(1970, 1990).forEach(System.out::println);

            System.out.println("Now you can debug the database before closing this app:");
            System.out.println(" - O");


            System.out.println("Press ENTER to exit");
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } finally {
            server.stop();
        }
    }
}
