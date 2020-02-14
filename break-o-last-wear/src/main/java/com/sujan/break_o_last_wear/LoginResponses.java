package com.sujan.break_o_last_wear;

public class LoginResponses {
    String status;
    String usertoken;

    public LoginResponses(String status, String usertoken) {
        this.status = status;
        this.usertoken = usertoken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(String usertoken) {
        this.usertoken = usertoken;
    }
}
