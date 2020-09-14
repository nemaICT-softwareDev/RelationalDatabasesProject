package org.fontys.thelearningmachines.data.model;



import org.fontys.thelearningmachines.data.model.interfaces.MemberInterface;

import java.text.MessageFormat;
import java.util.Date;

public class Member implements MemberInterface {


     @Override
     public String toString() {
         return MessageFormat.format("{0} {1},  {2}, ({3}) - {4} - {5} - {6} - {7} - {8} - {9} ",
                 this.getSurname(), this.getLastname(),
                 this.getEmail(), this.getTelephone(),
                 this.getPhoto(), this.getNickName(),
                 this.getGender(), this.getDateOfBirth(),
                 this.getCountryShortName(),
                 this.getIsActive());
     }

        private String surname;
        private String lastname;
        private String emailAddress;
        private String telephone;
        private String photo;
        private String nickname;
        private String gender;
        private Date dateOfBirth;
        private String countryShortName;
        private String password;
        private char isActive;


    public Member(){}


     @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public String getEmail() {
        return emailAddress;
    }

    @Override
    public String getTelephone() {
        return telephone;
    }

    @Override
    public String getPhoto() {
        return photo;
    }

    @Override
    public String getNickName() {
        return nickname;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String getCountryShortName() {
        return countryShortName;
    }

    @Override
    public char getIsActive() {
        return isActive;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public void setEmailAddress(String mailaddress) {
        this.emailAddress = mailaddress;
    }

    @Override
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void setCountryShortName(String countryShortName) {
        this.countryShortName = countryShortName;
    }

    @Override
    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }
}
