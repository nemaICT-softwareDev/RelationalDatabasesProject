package org.fontys.thelearningmachines.application.service.dao;

import org.fontys.thelearningmachines.application.entity.EntityInterface;
import org.fontys.thelearningmachines.application.entity.music.SpotifyModel;
import org.fontys.thelearningmachines.application.entity.music.SpotifyInterface;
import org.fontys.thelearningmachines.domain.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.domain.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.application.service.reader.FileReaderImpl;
import org.fontys.thelearningmachines.application.service.reader.FileReadException;
import org.fontys.thelearningmachines.domain.value.PathNames;

import org.slf4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;

public final class ProcessSpotifyData extends AbstractDataProcess {

    public ProcessSpotifyData(Logger logger) throws FileReadException {
        super(logger);
    }

    @Override
    public List<EntityInterface> ReadData() throws FileReadException {
        ReaderOptionInterface options = ReaderOptionBuilder.aReaderOption()
                .withPathname(PathNames.asSpotify())
                .build();

        return new FileReaderImpl(options).getList()
                .stream()
                .map(parts -> new SpotifyModel(parts[0], parts[1]))
                .collect(Collectors.toList());
    }

    @Override
    public Integer PersistData(List<EntityInterface> list) {
        try (Connection connection = DriverManager.getConnection(super.getConnection())) {
            for (EntityInterface entity : list) {
                SpotifyInterface music = (SpotifyInterface) entity;
                PreparedStatement statement = connection.prepareStatement("EXECUTE [dbo].[UpdateMusic] ?, ?;", Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, music.getName());
                statement.setString(2, music.getLink());

                statement.execute();

                super.getLogger().info(music.toString());
            }
        } catch (SQLException e) {
            super.getLogger().error("{}", e.getMessage());
        }

        return list.size();
    }
}
