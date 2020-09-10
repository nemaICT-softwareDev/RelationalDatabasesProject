package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.model.Member;
import org.fontys.thelearningmachines.data.model.MemberInterface;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.reader.MemberReader;
import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        // Process Member data
        List<MemberInterface> memberList = new MemberReader(PathNames.asMemberList()).getList().stream()
                .map(memberDetails -> {
                    Member member = new Member();
                    Date birthDate = new Date();
                    try {
                                /*Note the importance of the explicit Locale argument. If you omit it,
                                then it will use the default locale which is not necessarily English
                                as used in the month name of the input string.
                                If the locale doesn't match with the input string, then you would confusingly
                                get a java.text.ParseException even though when the format pattern seems valid.*/
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

                    return member;})
                .filter(obj -> !obj.getSurname().contains("surname")).collect(Collectors.toList());

        System.out.println(memberList.size());
        memberList.forEach(member -> logger.info(member.toString()));
    }
}
