package org.fontys.thelearningmachines.application.service.dao;

import org.fontys.thelearningmachines.application.entity.EntityInterface;
import org.fontys.thelearningmachines.application.entity.gender.GenderInterface;
import org.fontys.thelearningmachines.application.entity.gender.GenderModel;
import org.fontys.thelearningmachines.application.service.reader.FileReadException;
import org.fontys.thelearningmachines.application.service.reader.FileReaderImpl;
import org.fontys.thelearningmachines.domain.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.domain.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.domain.value.PathNames;
import org.slf4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;

public final class ProcessGenderData extends AbstractDataProcess {

    public ProcessGenderData(Logger logger) throws FileReadException {
        super(logger);
    }

    @Override
    public List<EntityInterface> ReadData() throws FileReadException {
        ReaderOptionInterface options = ReaderOptionBuilder.aReaderOption()
                .withPathname(PathNames.asGenderList())
                .build();

        return new FileReaderImpl(options).getList()
                .stream()
                .map(gender -> new GenderModel(gender[0]))
                .collect(Collectors.toList());
    }

    @Override
    public Integer PersistData(List<EntityInterface> list) {
        try (Connection connection = DriverManager.getConnection(super.getConnection())) {
            for (EntityInterface entity : list) {
                GenderInterface gender = (GenderInterface) entity;
                PreparedStatement statement = connection.prepareStatement("EXECUTE [dbo].[UpdateGenders] ?;", Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, gender.getGender());

                statement.execute();

                super.getLogger().info(gender.toString());
            }
        } catch (SQLException e) {
            super.getLogger().error("{}", e.getMessage());
        }

        return list.size();
    }
}
