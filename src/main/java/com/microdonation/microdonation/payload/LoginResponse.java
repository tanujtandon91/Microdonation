package com.microdonation.microdonation.payload;

public class LoginResponse
{

    private long userId;
    private String userName;
    private String email;
    private String role;
    private boolean userStatus;
    private boolean lockedUser;
    private String mobile;
    private String name;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public boolean getLockedUser() {
        return lockedUser;
    }

    public void setLockedUser(boolean lockedUser) {
        this.lockedUser = lockedUser;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public boolean isLockedUser() {
        return lockedUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
