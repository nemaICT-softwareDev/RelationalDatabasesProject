package org.fontys.thelearningmachines.application.service.dao;

import org.fontys.thelearningmachines.application.entity.EntityInterface;
import org.fontys.thelearningmachines.application.service.reader.FileReadException;

import java.util.List;

public interface ProcessDataInterface {

    List<EntityInterface> ReadData() throws FileReadException;

    Integer PersistData(List<EntityInterface> list);
}
