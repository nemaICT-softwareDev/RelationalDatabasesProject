package org.fontys.thelearningmachines.data.reader;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

final public class FileReader extends AbstractReader implements ReaderInterface {

    public FileReader(String pathname) throws FileReadException {
        super(pathname);
    }

    public List<String[]> getList() throws FileReadException {
        try {
            return FileUtils.readLines(this.getFile(), StandardCharsets.UTF_8).stream()
                .map(s -> s.split(";"))
                .collect(Collectors.toList())
            ;
        } catch (IOException e) {
            throw new FileReadException(this.getFile().getPath());
        }
    }


}
