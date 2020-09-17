package org.fontys.thelearningmachines.application.service.dao;

import org.fontys.thelearningmachines.application.entity.member.MemberInterface;
import org.fontys.thelearningmachines.application.entity.member.MemberModel;
import org.fontys.thelearningmachines.application.service.reader.FileReadException;
import org.fontys.thelearningmachines.application.service.reader.FileReaderImpl;
import org.fontys.thelearningmachines.domain.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.domain.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.domain.value.PathNames;
import org.fontys.thelearningmachines.infrastructure.database.DatabaseConnection;
import org.slf4j.Logger;

import java.sql.*;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public final class ProcessMemberData {

    public ProcessMemberData(Logger logger) throws FileReadException {

        ReaderOptionInterface options =  ReaderOptionBuilder.aReaderOption()
                .withPathname(PathNames.asMemberList())
                .withSkipRows(1)
                .build();

        List<MemberInterface> memberList = new FileReaderImpl(options).getList()
                .stream()
                .map(memberDetails -> {
                    MemberInterface member = new MemberModel();
                    try {
                        member.setSurname(memberDetails[0]);
                        member.setLastname(memberDetails[1]);
                        member.setEmailAddress(memberDetails[2]);
                        member.setTelephone(memberDetails[3]);
                        member.setPhoto(memberDetails[4]);
                        member.setNickname(memberDetails[5]);
                        member.setGender(memberDetails[6]);
                        member.setDateOfBirth(memberDetails[7]);
                        member.setCountryShortName(memberDetails[8]);
                        member.setPassword(memberDetails[9]);
                        member.setIsActive(memberDetails[10]);
                    } catch (ParseException e) {
                        logger.error("{}", e.getMessage());
                    }
                    return member;
                })
                .collect(Collectors.toList());

        String connectionUrl = new DatabaseConnection().getConnectionUrl();

        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            for (MemberInterface member : memberList) {
                PreparedStatement statement = connection.prepareStatement("EXECUTE dbo.MemberList ?, ?, ?,?,?,?,?,?,?,?,?;", Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, member.getSurname());
                statement.setString(2, member.getLastname());
                statement.setString(3, member.getNickName());
                statement.setString(4, member.getEmail());
                statement.setString(5, member.getTelephone());
                statement.setString(6, member.getPhoto());
                statement.setString(7, member.getGender());
                statement.setString(8, member.getPassword());
                statement.setDate(9, (java.sql.Date) member.getDateOfBirth());
                statement.setString(10, member.getCountryShortName());
                statement.setBoolean(11, member.getIsActive());
                statement.execute();

                logger.info(member.toString());
            }
        } catch (SQLException e) {
            logger.error("{}", e.getMessage());
        }
    }
}
