package com.example.home.myapplication;

/**
 * Created by USER on 2018-05-21.
 */

public class User {
    private String Email;
    private String PW;

    public User(){

    }
    public User(String id, String pw){
        this.Email = id;
        this.PW=pw;
    }
    public String getUserID(){return Email;}
    public void setUserID(String id){this.Email=id;}
    public String getUserPW(){return PW;}
    public void setUserPW(String pw){this.PW=pw;}

}
