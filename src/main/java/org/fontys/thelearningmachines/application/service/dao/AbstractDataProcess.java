package org.fontys.thelearningmachines.application.service.dao;

import org.fontys.thelearningmachines.application.entity.EntityInterface;
import org.fontys.thelearningmachines.application.service.reader.FileReadException;
import org.fontys.thelearningmachines.infrastructure.database.DatabaseConnection;
import org.slf4j.Logger;

import java.util.List;

abstract public class AbstractDataProcess implements ProcessDataInterface {

    private final String connection;
    private final Logger logger;

    public AbstractDataProcess(Logger logger) throws FileReadException {
        this.connection = DatabaseConnection.getConnectionUrl();
        this.logger = logger;

        List<EntityInterface> sanitizedData = ReadData();
        Integer size = PersistData(sanitizedData);

        logger.error("Total size of {} is: {}.", this.getClass().getSimpleName(), size);
    }

    public String getConnection() {
        return connection;
    }

    public Logger getLogger() {
        return logger;
    }

    abstract public List<EntityInterface> ReadData() throws FileReadException;

    abstract public Integer PersistData(List<EntityInterface> list);
}
