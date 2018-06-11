package com.example.home.myapplication;

/**
 * Created by USER on 2018-05-21.
 */

public class User {
    private String Email;
    private String PW;
    private String Name,Phone;
    private boolean Gender;//true-> 여자  false ->남자
    private int period;
    private String school;
    private int money;



    public User(){

    }
    public User(String id, String pw,String name,String phone, boolean gender,int period,int money,String school){
        this.Name=name;
        this.Phone=phone;
        this.Gender=gender;
        this.Email = id;
        this.PW=pw;
        this.period=period;
        this.school=school;
        this.money=money;
    }
    public User( String phone,String pw,String name, boolean gender,int period,int money,String school){
       this.Email=null;
        this.Name=name;
        this.Phone=phone;
        this.Gender=gender;
        this.PW=pw;
        this.period=period;
        this.school=school;
        this.money=money;
    }
    public String getUserID(){return Email;}
    public void setUserID(String id){this.Email=id;}
    public String getUserPW(){return PW;}
    public void setUserPW(String pw){this.PW=pw;}
    public String getName(){return Name;}
    public void setName(String name){this.Name=name;}
    public String getPhone(){return Phone;}
    public void setPhone(String phone){this.Phone=phone;}
    public void setGender(boolean gender){this.Gender=gender;}
    public boolean getGender(){return  Gender;}
    public void setPeriod(int period){this.period=period;}
    public int getPeriod(){return  period;}
    public void setSchool(String school){this.school=school;}
    public String getSchool(){return school;}
    public void setMoney(int money){this.money=money;}
    public int getMoney(){return money;}

}
