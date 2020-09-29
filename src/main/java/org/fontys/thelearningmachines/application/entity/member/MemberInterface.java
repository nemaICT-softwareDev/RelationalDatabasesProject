package org.fontys.thelearningmachines.application.entity.member;

import org.fontys.thelearningmachines.application.entity.EntityInterface;

import java.text.ParseException;
import java.util.Date;

public interface MemberInterface extends EntityInterface {

    void setPassword(String password);

    void setSurname(String surname);

    void setLastname(String lastname);

    void setEmailAddress(String mailaddress);

    void setTelephone(String telephone);

    void setPhoto(String photo);

    void setNickname(String nickname);

    void setGender(String gender);

    void setDateOfBirth(String dateOfBirth, String format) throws ParseException;

    void setCountryShortName(String countryShortName);

    void setCreatedDate(String createdDate, String format) throws ParseException;

    void setIsActive(boolean isActive);

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

    Date getCreatedDated();

    boolean getIsActive();

}
