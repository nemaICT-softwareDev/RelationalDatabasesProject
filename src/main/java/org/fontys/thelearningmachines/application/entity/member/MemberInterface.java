package org.fontys.thelearningmachines.application.entity.member;

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
    void setDateOfBirth(Date dateOfBirth);
    void setCountryShortName(String countryShortName);

    boolean getIsActive();

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

    void setIsActive(String isActive);
}
