package org.fontys.thelearningmachines.data.reader;

import java.text.MessageFormat;

public class FileReadException extends Exception {

    public FileReadException(String path) {
        super(MessageFormat.format("The file {0} does not exist!", path));
    }
}
