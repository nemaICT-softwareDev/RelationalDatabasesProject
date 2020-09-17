package org.fontys.thelearningmachines.application.service.reader;

import java.io.File;
import java.util.List;

public interface ReaderInterface {

    File getFile();

    List<String[]> getList() throws FileReadException;
}
