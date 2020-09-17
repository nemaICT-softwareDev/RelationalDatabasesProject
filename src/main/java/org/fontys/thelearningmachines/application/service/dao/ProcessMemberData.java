package org.fontys.thelearningmachines.application.service.dao;

import org.fontys.thelearningmachines.application.entity.member.MemberModel;
import org.fontys.thelearningmachines.application.entity.member.MemberInterface;
import org.fontys.thelearningmachines.domain.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.domain.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.application.service.reader.FileReaderImpl;
import org.fontys.thelearningmachines.application.service.reader.FileReadException;
import org.fontys.thelearningmachines.domain.value.PathNames;
import org.slf4j.Logger;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
                    Date birthDate = new Date();
                    try {
                        birthDate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(memberDetails[7]);
                    } catch (ParseException e) {
                        logger.error("{}", e.getMessage());
                    }
                    member.setSurname(memberDetails[0]);
                    member.setLastname(memberDetails[1]);
                    member.setEmailAddress(memberDetails[2]);
                    member.setTelephone(memberDetails[3]);
                    member.setPhoto(memberDetails[4]);
                    member.setNickname(memberDetails[5]);
                    member.setGender(memberDetails[6]);
                    member.setDateOfBirth(birthDate);
                    member.setCountryShortName(memberDetails[8]);
                    member.setPassword(memberDetails[9]);
                    member.setIsActive(memberDetails[10].charAt(0));

                    return member;
                })
                .collect(Collectors.toList());

        logger.info(MessageFormat.format("Number of membersList in list {0}", memberList.size()));

        memberList.forEach(member -> logger.info(member.toString()));
    }
}
