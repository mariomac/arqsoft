package edu.upc.swarch.jpa;

import org.h2.tools.Server;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // start the TCP Server
        Server server = Server.createWebServer("-web","-webAllowOthers","-webPort","8082").start();
          
    }
}
