package org.fontys.thelearningmachines.data.model.interfaces;

import java.text.ParseException;
import java.util.Date;

public interface MemberInterface {

    void setPassword(String password);
    void setSurname(String surname);
    void setLastname(String lastname);
    void setEmailAddress(String mailaddress);
    void setTelephone(String telephone);
    void setPhoto(String photo);
    void setNickname(String nickname);
    void setGender(String gender);
    void setDateOfBirth(String dateOfBirth) throws ParseException;
    void setCountryShortName(String countryShortName);
    void setIsActive(char isActive);

    String getPassword();
    String getSurname();
    String getLastname();
    String getEmail();
    String getTelephone();
    String getPhoto();
    String getNickName();
    String getGender();
    Date getDateOfBirth();
    String getCountryShortName();
    char getIsActive();
}
