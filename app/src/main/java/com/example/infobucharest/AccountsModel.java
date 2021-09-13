package com.example.infobucharest;

public class AccountsModel {
    public String firstName;
    public int phoneNumber;
    public String emailAddress;
    public String password;

    public AccountsModel(String fn, int pn, String ea, String pw){
        this.firstName = fn;
        this.phoneNumber = pn;
        this.emailAddress = ea;
        this.password = pw;
    }

    public AccountsModel() {}

    @Override
    public String toString() {
        return "AccountsModel{" +
                "firstName='" + firstName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
