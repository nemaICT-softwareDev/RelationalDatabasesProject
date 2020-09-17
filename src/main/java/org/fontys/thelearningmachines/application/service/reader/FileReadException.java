package org.fontys.thelearningmachines.application.service.reader;

import java.text.MessageFormat;

public class FileReadException extends Exception {

    public FileReadException(String path) {
        super(MessageFormat.format("Cannot read from file {0}!", path));
    }
}
