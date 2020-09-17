package org.fontys.thelearningmachines.data.model.interfaces;

import java.text.ParseException;
import java.util.Date;

public interface MemberInterface {

    void setSurname(String surname);

    void setLastname(String lastname);

    void setNickname(String nickname);

    void setEmailAddress(String mailaddress);

    void setTelephone(String telephone);

    void setPhotoUrl(String photoUrl);

    String getNickName();

    String getPhotoUrl();

    void setDateOfBirth(String dateOfBirth) throws ParseException;

    String getGenderId();

    void setGenderId(String genderId);

    String getSurname();

    String getLastname();

    String getPassword();

    String getEmail();

    String getTelephone();

    void setPassword(String password);

    String getCountryId();

    void setCountryId(String countryId);

    Date getDateOfBirth();

    boolean getIsActive();

    void setIsActive(String isActive);


}
