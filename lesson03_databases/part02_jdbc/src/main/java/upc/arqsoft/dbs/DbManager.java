package upc.arqsoft.dbs;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbManager {
    private Server server;
    private String user, password;
    private String dbUrl;

    public DbManager(String dbUrl, String user, String password) {
        this.user = user;
        this.password = password;
        this.dbUrl = dbUrl;
    }

    public void startService() throws Exception {
        server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8080", "-ifNotExists");
        server.start();
    }

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(dbUrl, user, password);
    }

    public void stop() {
        if (server != null) {
            server.stop();
            server = null;
        }
    }
}
