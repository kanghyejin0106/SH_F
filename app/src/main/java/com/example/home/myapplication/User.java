package com.example.home.myapplication;

/**
 * Created by USER on 2018-05-21.
 */

public class User {
    private String Email;
    private String PW;
    private String Name,Phone;
    private int Gender;//true-> 여자  false ->남자


    public User(){

    }
    public User(String id, String pw,String name,String phone, int gender){
        this.Name=name;
        this.Phone=phone;
        this.Gender=gender;
        this.Email = id;
        this.PW=pw;

    }
    public User( String phone,String pw,String name, int gender){
        this.Email=null;
        this.Name=name;
        this.Phone=phone;
        this.Gender=gender;
        this.PW=pw;

    }
    public String getUserID(){return Email;}
    public void setUserID(String id){this.Email=id;}
    public String getUserPW(){return PW;}
    public void setUserPW(String pw){this.PW=pw;}
    public String getName(){return Name;}
    public void setName(String name){this.Name=name;}
    public String getPhone(){return Phone;}
    public void setPhone(String phone){this.Phone=phone;}
    public void setGender(int gender){this.Gender=gender;}
    public int getGender(){return  Gender;}


}