package org.fontys.thelearningmachines.data.model;


import java.util.Date;

public class Member implements MemberInterface{


     @Override
     public String toString() {
         return "Member{" +
                 "surname='" + surname + '\'' +
                 ", lastname='" + lastname + '\'' +
                 ", emailaddress='" + emailaddress + '\'' +
                 ", telephone='" + telephone + '\'' +
                 ", photo='" + photo + '\'' +
                 ", nickname='" + nickname + '\'' +
                 ", gender='" + gender + '\'' +
                 ", dateOfBirth=" + dateOfBirth +
                 ", countryShortName='" + countryShortName + '\'' +
                 '}';
     }

     private String surname;
    private String lastname;
    private String emailaddress;
    private String telephone;
    private String photo;
    private String nickname;
    private String gender;
    private Date dateOfBirth;
    private String countryShortName;
    private String password;

    public Member(String surname,
                  String lastname,
                  String emailaddress,
                  String telephone,
                  String photo,
                  String nickname,
                  String gender,
                  Date dateOfBirth,
                  String countryShortName,
                  String password) {

        this.surname = surname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.telephone = telephone;
        this.photo = photo;
        this.nickname = nickname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.countryShortName = countryShortName;
        this.password = password;
    }

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
        return emailaddress;
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
        return gender;
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
        this.emailaddress = mailaddress;
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
}
