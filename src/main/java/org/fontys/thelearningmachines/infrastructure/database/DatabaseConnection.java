package org.fontys.thelearningmachines.infrastructure.database;

public class DatabaseConnection {

    private final String connectionUrl;

    public DatabaseConnection() {
        this.connectionUrl = "jdbc:sqlserver://mssql.fhict.local:1433;" +
                "database=dbi431929;" +
                "user=dbi431929;" +
                "password=FontysICTs4!;" +
                "encrypt=false;" +
                "trustServerCertificate=false;" +
                "loginTimeout=30;";
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }
}
