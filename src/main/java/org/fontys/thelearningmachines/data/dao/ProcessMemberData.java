package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.model.MemberModel;
import org.fontys.thelearningmachines.data.model.interfaces.MemberInterface;
import org.fontys.thelearningmachines.data.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.data.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.reader.FileReaderImpl;
import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
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
                        member.setPhotoUrl(memberDetails[4]);
                        member.setNickname(memberDetails[5]);
                        member.setGenderId(memberDetails[6]);
                        member.setDateOfBirth(memberDetails[7]);
                        member.setCountryId(memberDetails[8]);
                        member.setPassword(memberDetails[9]);
                        member.setIsActive(memberDetails[10]);
                    } catch (ParseException e) {
                        logger.error("{}", e.getMessage());
                    }
                    return member;
                })
                .collect(Collectors.toList());

        String connectionUrl = new DatabaseConnector().dbConnector();

        try (Connection connection = DriverManager.getConnection(connectionUrl)) {

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Member");

            List<MemberInterface> memberResult = new ArrayList<>();
            try {
                while (result.next()) {
                    MemberInterface member = new MemberModel();
                    //memberResult.add(new MemberModel()
                    member.setSurname(result.getString("Surname"));
                    member.setLastname(result.getString("Lastname"));
                    member.setNickname(result.getString("Nickname"));
                    member.setEmailAddress(result.getString("Emailaddress"));
                    member.setTelephone(result.getString("Telephone"));
                    member.setPhotoUrl(result.getString("PhotoUrl"));
                    member.setGenderId(result.getString("GenderId"));
                    member.setPassword(result.getString("Password"));
                    member.setDateOfBirthBackFromDatabase(result.getString("DateOfBirth"));
                    member.setCountryId(result.getString("CountryId"));
                    member.setIsActive(result.getString("IsActive"));

                    memberResult.add(member);
                }
            } catch (ParseException ex) {
                logger.error("{}", ex.getMessage());
            }

            for (MemberInterface member : memberList) {
                connection.prepareStatement("INSERT INTO [Member] (Surname, Lastname, Nickname, " +
                        "Emailaddress, Telephone, PhotoUrl, GenderId, Password, DateOfBirth, " +
                        "CountryId, isActive) " +
                        "VALUES ('" + member.getSurname() + "','" + member.getLastname() + "'," +
                        "'" + member.getNickName() + "','" + member.getEmail() + "'," +
                        "'" + member.getTelephone() + "', '" + member.getPhotoUrl() + "'," +
                        "'" + member.getGenderId() + "', '" + member.getPassword() + "'," +
                        "'" + member.getDateOfBirth() + "', '" + member.getCountryId() + "'," +
                        "'" + member.getIsActive() + "' );", Statement.RETURN_GENERATED_KEYS).execute();
                logger.info(member.toString());
            }
        } catch (SQLException e) {
            logger.error("{}", e.getMessage());
        }
//        logger.info(MessageFormat.format("Number of membersList in list {0}", memberList.size()));
//        memberList.forEach(member -> logger.info(member.toString()));
    }
}
