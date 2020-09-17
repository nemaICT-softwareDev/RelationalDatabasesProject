package org.fontys.thelearningmachines.application.service.reader;

import org.fontys.thelearningmachines.domain.option.ReaderOptionInterface;

import java.io.File;

public abstract class AbstractReader {

    private final File file;
    private final ReaderOptionInterface options;

    public ReaderOptionInterface getOptions() {
        return options;
    }

    public AbstractReader(ReaderOptionInterface options) throws FileReadException {
        this.options = options;

        this.file = new File(options.getPathname());

        if (!file.exists()) {
            throw new FileReadException(options.getPathname());
        }
    }

    public File getFile() {
        return this.file;
    }
}
