package org.fontys.thelearningmachines;

import org.fontys.thelearningmachines.data.model.Member;
import org.fontys.thelearningmachines.data.model.MemberInterface;
import org.fontys.thelearningmachines.data.model.SpotifyDataModel;
import org.fontys.thelearningmachines.data.model.SpotifyInterface;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.reader.MemberReader;
import org.fontys.thelearningmachines.data.reader.SpotifyReader;

import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(org.fontys.thelearningmachines.Main.class);

    public static void main(String[] args) {
        try {
            // Process Spotify data
            List<SpotifyInterface> spotifyList = new SpotifyReader(PathNames.asSpotify()).getList().stream()
                .map(parts -> new SpotifyDataModel(parts[0], parts[1]))
                .collect(Collectors.toList())
            ;
            spotifyList.forEach(model -> logger.info(model.toString()));

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

        } catch (FileReadException e) {
            logger.error("{}", e.getMessage());
        }
    }
}
