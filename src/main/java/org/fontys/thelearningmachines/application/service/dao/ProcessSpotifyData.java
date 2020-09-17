package org.fontys.thelearningmachines.application.service.dao;

import org.fontys.thelearningmachines.application.entity.music.SpotifyModel;
import org.fontys.thelearningmachines.application.entity.music.SpotifyInterface;
import org.fontys.thelearningmachines.domain.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.domain.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.application.service.reader.FileReaderImpl;
import org.fontys.thelearningmachines.application.service.reader.FileReadException;
import org.fontys.thelearningmachines.domain.value.PathNames;
import org.fontys.thelearningmachines.infrastructure.database.DatabaseConnection;

import org.slf4j.Logger;

import java.sql.*;
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

        String connectionUrl = new DatabaseConnection().getConnectionUrl();

        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            for (SpotifyInterface music : spotifyList) {
                PreparedStatement statement = connection.prepareStatement("EXECUTE dbo.SpotifyList ?, ?;", Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, music.getName());
                statement.setString(2, music.getLink());

                statement.execute();

                logger.info(music.toString());
            }
        } catch (SQLException e) {
            logger.error("{}", e.getMessage());
        }
    }
}
