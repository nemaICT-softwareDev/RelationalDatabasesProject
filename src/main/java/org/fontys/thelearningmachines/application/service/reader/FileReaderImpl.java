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
            return FileUtils.readLines(this.getFile(), StandardCharsets.UTF_8)
                .stream()
                .skip(super.getOptions().getSkipRows())
                .map(s -> s.split(";"))
                .collect(Collectors.toList())
            ;
        } catch (IOException e) {
            throw new FileReadException(this.getFile().getPath());
        }
    }


}
