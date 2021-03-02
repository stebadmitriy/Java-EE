package ru.clevertec.entities;

import java.util.Map;

public class User {
    private String firstName;
    private String secondName;
    private int age;
    private Map<String, String> credentials;
    private UserType userType;

    public User(String firstName, String secondName, int age, Map<String, String> credentials, UserType userType) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.credentials = credentials;
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", credentials=" + credentials +
                ", userType=" + userType +
                '}';
    }
}
