package com.example.home.myapplication;

/**
 * Created by USER on 2018-06-17.
 */

public class SeniorQuestionData {
    boolean StudentGender;//true면 여자 false면 남자
    boolean furniture;//true면 가구제공 false면 가구 제공안함
    String furnitureType;//가구종류
    int security;//보안 종류 1이면 Doorlock 2이면 key 3이면 keys+shackles
    boolean wifi;//true면 wifi 제공 false면 제공안함
    boolean vactionRent;//ture면 방학동안에 살지않아도 돈을 내야함 false면 반대

    SeniorQuestionData(Boolean StudentGender,Boolean furniture,String furnitureType,
                       int security,Boolean wifi,Boolean vactionRent){
        this.StudentGender=StudentGender;
        this.furniture=furniture;
        this.furnitureType=furnitureType;
        this.security=security;
        this.wifi=wifi;
        this.vactionRent=vactionRent;
    }

    public void setStudentGender(Boolean studentGender) {
        StudentGender = studentGender;
    }

    public Boolean getStudentGender() {
        return StudentGender;
    }

    public void setFurniture(Boolean furniture) {
        this.furniture = furniture;
    }

    public Boolean getFurniture() {
        return furniture;
    }

    public void setFurnitureType(String furnitureType) {
        this.furnitureType = furnitureType;
    }

    public String getFurnitureType() {
        return furnitureType;
    }

    public void setSecurity(int security) {
        this.security = security;
    }

    public int getSecurity() {
        return security;
    }

    public void setVactionRent(Boolean vactionRent) {
        this.vactionRent = vactionRent;
    }

    public Boolean getVactionRent() {
        return vactionRent;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getWifi() {
        return wifi;
    }
}
