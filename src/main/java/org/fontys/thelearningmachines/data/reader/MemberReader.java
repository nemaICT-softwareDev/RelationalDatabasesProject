package org.fontys.thelearningmachines.data.reader;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class MemberReader extends AbstractReader implements ReaderInterface{

    public MemberReader(String pathname) throws FileReadException {
        super(pathname);
    }

    @Override
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
