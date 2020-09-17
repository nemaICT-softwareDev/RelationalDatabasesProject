package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.model.SpotifyModel;
import org.fontys.thelearningmachines.data.model.interfaces.SpotifyInterface;
import org.fontys.thelearningmachines.data.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.data.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.reader.FileReaderImpl;
import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

        String connectionUrl = new DatabaseConnector().dbConnector();

        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            for (SpotifyInterface music : spotifyList) {
                connection.prepareStatement("INSERT INTO [Music] (MusicId, SpotifyLink) VALUES ('" + music.getName() + "', '" + music.getLink() + "');", Statement.RETURN_GENERATED_KEYS).execute();
                logger.info(music.toString());
            }
        } catch (SQLException e) {
            logger.error("{}", e.getMessage());
        }
    }
}
