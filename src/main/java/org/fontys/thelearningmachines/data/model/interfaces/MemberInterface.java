package org.fontys.thelearningmachines.data.model.interfaces;

import java.text.ParseException;
import java.util.Date;

public interface MemberInterface {

    void setPassword(String password);

    void setSurname(String surname);

    void setEmailAddress(String emailAddress);

    void setDateOfBirth(String dateOfBirth) throws ParseException;

    void setTelephone(String telephone);

    void setPhoto(String photo);

    void setNickname(String nickname);

    void setGender(String gender);

    String getLastName();

    void setCountryShortName(String countryShortName);

    void setIsActive(char isActive);

    String getPassword();

    String getSurname();

    void setLastName(String lastName);

    String getEmail();

    String getTelephone();

    String getPhoto();

    String getNickName();

    String getGender();

    Date getDateOfBirth();

    String getCountryShortName();

    char getIsActive();
}
