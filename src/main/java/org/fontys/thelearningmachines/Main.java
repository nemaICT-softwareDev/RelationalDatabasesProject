package org.fontys.thelearningmachines;

import org.fontys.thelearningmachines.data.model.SpotifyDataModel;
import org.fontys.thelearningmachines.data.model.SpotifyInterface;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.reader.SpotifyReader;

import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(org.fontys.thelearningmachines.Main.class);

    public static void main(String[] args) {
        try {
            // Process Spotify data
            List<SpotifyInterface> spotifyList = new SpotifyReader(PathNames.asSpotify()).getList().stream()
                .map(parts -> new SpotifyDataModel(parts[0], parts[1]))
                .collect(Collectors.toList())
            ;
            spotifyList.forEach(model -> logger.info(model.toString()));
        } catch (FileReadException e) {
            logger.error("{}", e.getMessage());
        }
    }
}
