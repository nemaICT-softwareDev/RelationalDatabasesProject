package org.fontys.thelearningmachines.data.reader;

import java.io.File;

abstract public class AbstractReader {

    private final File file;

    public AbstractReader(String pathname) throws FileReadException {
        this.file = new File(pathname);

        if (!file.exists()) {
            throw new FileReadException(pathname);
        }
    }

    public File getFile() {
        return this.file;
    }
}
