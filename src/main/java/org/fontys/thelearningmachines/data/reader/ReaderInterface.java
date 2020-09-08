package org.fontys.thelearningmachines.data.reader;

import java.io.File;
import java.util.List;

public interface ReaderInterface {

    File getFile();

    List<String[]> getList() throws FileReadException;
}
