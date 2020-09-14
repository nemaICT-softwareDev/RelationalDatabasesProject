package org.fontys.thelearningmachines.data.model.interfaces;


import org.fontys.thelearningmachines.data.model.Gender;

import java.util.Date;

public interface MemberInterface {

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


    void setPassword(String password);
    void setSurname(String surname);
    void setLastname(String lastname);
    void setEmailAddress(String mailaddress);
    void setTelephone(String telephone);
    void setPhoto(String photo);
    void setNickname(String nickname);
    void setGender(String gender);
    void setDateOfBirth(Date dateOfBirth);
    void setCountryShortName(String countryShortName);
    void setIsActive(char isActive);

}
