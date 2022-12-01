package com.example.myapplication;

public class UserDTO {

    private int id;
    private String userName;
    private String userType;
    private String userEmail;
    private String userPassword;
    private String userMembershipType;

    // Constructor for UserDTO
    public UserDTO(String userName, String userType, String userMembershipType, String userEmail, String userPassword) {
        this.userName = userName;
        this.userType = userType;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userMembershipType = userMembershipType;
    }

    // Creating Getters

    public int getId() {
        return id;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserMembershipType() {
        return userMembershipType;
    }

    // Creating Setters

    public void setId(int id){
        this.id = id;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserMembershipType(String userMembershipType) {
        this.userMembershipType = userMembershipType;
    }


}
