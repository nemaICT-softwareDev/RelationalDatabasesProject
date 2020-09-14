package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.model.Member;
import org.fontys.thelearningmachines.data.model.interfaces.MemberInterface;
import org.fontys.thelearningmachines.data.reader.FileReader;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

  public class ProcessMemberData {

      public ProcessMemberData() {
      }

      public void getMembers(Logger logger) throws FileReadException {

          try {
              // Process Member data
              List<MemberInterface> memberList = new FileReader(PathNames.asMemberList()).getList().stream()
                      .map(memberDetails -> {
                          MemberInterface member = new Member();
                          Date birthDate = new Date();
                       try {
                            birthDate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(memberDetails[7]);
                       } catch (ParseException e) {
                              e.printStackTrace();
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
                      .filter(obj -> !obj.getSurname().contains("surname")).collect(Collectors.toList());

             logger.info(MessageFormat.format("Number of membersList in list {0}", memberList.size()));

              memberList.forEach(member -> logger.info(member.toString()));
          }catch(FileReadException ex){
              logger.error("{}", ex.getMessage());
          }
    }
}
