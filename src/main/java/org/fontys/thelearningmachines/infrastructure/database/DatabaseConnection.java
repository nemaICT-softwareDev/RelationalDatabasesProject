package org.fontys.thelearningmachines.infrastructure.database;

public class DatabaseConnection {

    private final static String connectionUrl =
        "jdbc:sqlserver://mssql.fhict.local:1433;" +
        "database=dbi431216;" +
        "user=dbi431216;" +
        "password=D(X.EcF&Y9Sz$FPe;" +
        "encrypt=false;" +
        "trustServerCertificate=false;" +
        "loginTimeout=30;";

    public static String getConnectionUrl() {
        return connectionUrl;
    }
}
