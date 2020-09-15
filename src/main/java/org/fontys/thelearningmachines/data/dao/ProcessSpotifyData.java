package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.model.SpotifyModel;
import org.fontys.thelearningmachines.data.model.interfaces.SpotifyInterface;
import org.fontys.thelearningmachines.data.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.data.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.data.reader.FileReaderImpl;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public final class ProcessSpotifyData {

    public ProcessSpotifyData(Logger logger) throws FileReadException {

        ReaderOptionInterface options = ReaderOptionBuilder.aReaderOption()
                .withPathname(PathNames.asSpotify())
                .build();

        List<SpotifyInterface> spotifyList = new FileReaderImpl(options).getList()
                .stream()
                .map(parts -> new SpotifyModel(parts[0], parts[1]))
                .collect(Collectors.toList());

        spotifyList.forEach(model -> logger.info(model.toString()));
    }
}