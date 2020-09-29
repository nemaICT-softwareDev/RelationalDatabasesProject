package org.fontys.thelearningmachines.application.service.reader;

import org.apache.commons.io.FileUtils;
import org.fontys.thelearningmachines.domain.option.ReaderOptionInterface;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public final class FileReaderImpl extends AbstractReader implements ReaderInterface {

    public FileReaderImpl(ReaderOptionInterface options) throws FileReadException {
        super(options);
    }

    public List<String[]> getList() throws FileReadException {
        try {
            ReaderOptionInterface options = super.getOptions();

            return FileUtils.readLines(this.getFile(), StandardCharsets.UTF_8)
                .stream()
                .skip(options.getSkipRows())
                .limit(options.getLimitRows())
                .map(str -> str.split(options.getDelimiter()))
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileReadException(this.getFile().getPath());
        }
    }
}
