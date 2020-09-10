package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.model.SpotifyDataModel;
import org.fontys.thelearningmachines.data.model.SpotifyInterface;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.reader.SpotifyReader;
import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class ProcessSpotifyData {

    public ProcessSpotifyData() {
    }

    public void getSpotifyData(Logger logger) throws FileReadException {
        List<SpotifyInterface> spotifyList = new SpotifyReader(PathNames.asSpotify()).getList().stream()
                .map(parts -> new SpotifyDataModel(parts[0], parts[1]))
                .collect(Collectors.toList())
                ;
        spotifyList.forEach(model -> logger.info(model.toString()));
    }
}
