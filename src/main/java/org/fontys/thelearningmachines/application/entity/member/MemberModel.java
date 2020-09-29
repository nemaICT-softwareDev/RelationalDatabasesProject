package org.fontys.thelearningmachines.application.entity.member;

import java.text.DateFormat;
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
    private String photo;
    private String nickname;
    private String gender;
    private Date dateOfBirth;
    private String countryShortName;
    private String password;
    private boolean isActive;
    private Date createdDate;

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
    public void setDateOfBirth(String dateOfBirth, String format) throws ParseException {
        Date date = new SimpleDateFormat(format, Locale.ENGLISH).parse(dateOfBirth);
        this.dateOfBirth = new java.sql.Date(date.getTime());
    }

    @Override
    public void setCountryShortName(String countryShortName) {
        this.countryShortName = countryShortName;
    }

    @Override
    public void setCreatedDate(String createdDate, String format) throws ParseException {
        Date date = new SimpleDateFormat(format, Locale.ENGLISH).parse(createdDate);
        this.createdDate = new java.sql.Date(date.getTime());
    }

    @Override
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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
    public Date getCreatedDated() {
        return this.createdDate;
    }

    @Override
    public boolean getIsActive() {
        return this.isActive;
    }

    @Override
    public String toString() {
        return MessageFormat.format("[{0}] {1} {2} ({3}, {4}) - {5} - {6}:{7} - {8} - {9} {10}",
            this.getCountryShortName(),
            this.getSurname(),
            this.getLastname(),
            this.getEmail(),
            this.getTelephone(),
            this.getGender(),
            this.getNickName(),
            this.getPassword(),
            this.getDateOfBirth(),
            this.getIsActive(),
            this.getCreatedDated()
        );
    }
}
