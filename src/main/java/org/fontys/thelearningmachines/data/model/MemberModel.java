package org.fontys.thelearningmachines.data.model;

import org.fontys.thelearningmachines.data.model.interfaces.MemberInterface;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class MemberModel implements MemberInterface {

    private String surname;
    private String lastname;
    private String emailAddress;
    private String telephone;
    private String photoUrl;
    private String nickname;
    private String genderId;
    private Date dateOfBirth;
    private String countryId;
    private String password;
    private boolean isActive;

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
    public void setDateOfBirth(String dateOfBirth) throws ParseException {
        this.dateOfBirth = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(dateOfBirth);
        java.sql.Date sqlDate = new java.sql.Date(this.dateOfBirth.getTime());
        this.dateOfBirth = sqlDate;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String getPhotoUrl() {
        return photoUrl;
    }

    @Override
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String getGenderId() {
        return this.genderId;
    }

    @Override
    public boolean getIsActive() {
        return isActive;
    }

    @Override
    public String getPassword() {
        return password;
    }

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
    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    @Override
    public String getNickName() {
        return nickname;
    }

    @Override
    public String getCountryId() {
        return countryId;
    }

    @Override
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public void setIsActive(String isActive) {
        if (isActive.equals("y")) {
            this.isActive = true;
        }
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1},  {2}, ({3}) - {4} - {5} - {6} - {7} - {8} - {9} ",
                this.getSurname(), this.getLastname(),
                this.getEmail(), this.getTelephone(),
                this.getPhotoUrl(), this.getNickName(),
                this.getGenderId(), this.getDateOfBirth(),
                this.getCountryId(),
                this.getIsActive());
    }
}
