package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.model.interfaces.DatabaseConnectorInterface;

public final class DatabaseConnector implements DatabaseConnectorInterface {

    private String dbConnector;

    @Override
    public String dbConnector() {
        return this.dbConnector = "jdbc:sqlserver://mssql.fhict.local:1433;database=dbi431929;user=dbi431929;password=FontysICTs4!;encrypt=false;trustServerCertificate=false;loginTimeout=30;";
    }
}
