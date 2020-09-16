package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.model.MemberModel;
import org.fontys.thelearningmachines.data.model.interfaces.MemberInterface;
import org.fontys.thelearningmachines.data.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.data.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.reader.FileReaderImpl;
import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;

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
                        member.setIsActive(memberDetails[10].charAt(0));
                    } catch (ParseException e) {
                        logger.error("{}", e.getMessage());
                    }
                    return member;
                })
                .collect(Collectors.toList());

//        logger.info(MessageFormat.format("Number of membersList in list {0}", memberList.size()));
//        memberList.forEach(member -> logger.info(member.toString()));
    }
}
