package org.fontys.thelearningmachines.application.service.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.fontys.thelearningmachines.application.entity.EntityInterface;
import org.fontys.thelearningmachines.application.entity.member.MemberInterface;
import org.fontys.thelearningmachines.application.entity.member.MemberModel;
import org.fontys.thelearningmachines.application.service.reader.FileReadException;
import org.fontys.thelearningmachines.application.service.reader.FileReaderImpl;
import org.fontys.thelearningmachines.domain.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.domain.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.domain.value.PathNames;
import org.slf4j.Logger;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public final class ProcessPersonData extends AbstractDataProcess {

    public ProcessPersonData(Logger logger) throws FileReadException {
        super(logger);
    }

    @Override
    public List<EntityInterface> ReadData() throws FileReadException {
        ReaderOptionInterface options = ReaderOptionBuilder.aReaderOption()
                .withPathname(PathNames.asPersonList())
                .withSkipRows(2)
                .withLimitRows(60000)
                .withDelimiter("\\|")
                .build();

        return new FileReaderImpl(options).getList()
                .stream()
                .map(memberDetails -> {
                    MemberInterface member = new MemberModel();

                    try {
                        if (memberDetails[0].contains("-------")) {
                            member.setIsActive(false);
                        } else {
                            member.setSurname(memberDetails[3].trim());
                            member.setLastname(memberDetails[5].trim());
                            member.setEmailAddress(memberDetails[10].trim());
                            member.setTelephone(memberDetails[11].trim());
                            member.setNickname(memberDetails[3].trim().toLowerCase() + "." + memberDetails[5].trim().toLowerCase());
                            member.setGender(memberDetails[4].trim());
                            member.setDateOfBirth(memberDetails[12].trim(), "dd-M-yyyy");
                            member.setCountryShortName("NL");
                            member.setPassword(RandomStringUtils.randomAlphabetic(12));
                            member.setIsActive(true);
                            member.setCreatedDate(new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()), "dd-MM-yyyy");
                        }
                    } catch (ParseException e) {
                        super.getLogger().error("{}", e.getMessage());
                    }

                    return member;
                })
                .filter(MemberInterface::getIsActive)
                .collect(Collectors.toList());
    }

    @Override
    public Integer PersistData(List<EntityInterface> list) {
        try (Connection connection = DriverManager.getConnection(super.getConnection())) {
            for (EntityInterface entity : list) {
                MemberInterface member = (MemberInterface) entity;
                PreparedStatement statement = connection.prepareStatement("EXECUTE [dbo].[UpdateMembers] ?,?,?,?,?,?,?,?,?,?,?,?;", Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, member.getSurname());
                statement.setString(2, member.getLastname());
                statement.setString(3, member.getNickName());
                statement.setString(4, member.getEmail());
                statement.setString(5, member.getTelephone());
                statement.setString(6, member.getPhoto());
                statement.setString(7, member.getGender());
                statement.setString(8, member.getPassword());
                statement.setDate(9, (Date) member.getDateOfBirth());
                statement.setString(10, member.getCountryShortName());
                statement.setBoolean(11, member.getIsActive());
                statement.setDate(12, (Date) member.getCreatedDated());

                statement.execute();

                super.getLogger().info(member.toString());
            }
        } catch (SQLException e) {
            super.getLogger().error("{}", e.getMessage());
        }

        return list.size();
    }
}
