package org.fontys.thelearningmachines.data.model.interfaces;

import java.text.ParseException;
import java.util.Date;

public interface MemberInterface {

    void setPassword(String password);
    void setSurname(String surname);
    void setLastname(String lastname);
    void setEmailAddress(String mailaddress);
    void setTelephone(String telephone);
    String getPhotoUrl();
    void setNickname(String nickname);

    void setPhotoUrl(String photoUrl);
    void setDateOfBirth(String dateOfBirth) throws ParseException;

    String getGenderId();
    void setIsActive(char isActive);

    String getPassword();
    String getSurname();
    String getLastname();
    String getEmail();
    String getTelephone();

    void setGenderId(String genderId);
    String getNickName();

    String getCountryId();
    Date getDateOfBirth();

    void setCountryId(String countryId);
    char getIsActive();
}
