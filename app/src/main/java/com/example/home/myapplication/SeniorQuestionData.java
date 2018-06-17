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
    int q_religion;//종교 1. Christianity 2. Budhism 3. Catholic 4. Islam 5. No Religion
    int q_pet;//반려동물 1. 기르고 있으며 상관없 2.기르지 않으나 상관없 3. 싫어함
    int smoke;//1. always 2.often 3.Sometimes 4. Do not
    int alcohol;//1.always 2. often 3. Sometimes 4.Do not
    int breakfast;//1.I always eat 2.eat often 3. i eat sometimes 4.Do not eat


    SeniorQuestionData(Boolean StudentGender,Boolean furniture,String furnitureType,
                       int security,Boolean wifi,Boolean vactionRent,int q_religion,int q_pet,
                       int smoke,int alcohol,int breakfast){
        this.StudentGender=StudentGender;
        this.furniture=furniture;
        this.furnitureType=furnitureType;
        this.security=security;
        this.wifi=wifi;
        this.vactionRent=vactionRent;
        this.q_religion=q_religion;
        this.q_pet=q_pet;
        this.smoke=smoke;
        this.alcohol=alcohol;
        this.breakfast=breakfast;
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
    public void setQ_religion(int q_religion) {
        this.q_religion = q_religion;
    }

    public int getQ_religion() {
        return q_religion;
    }

    public void setQ_pet(int q_pet) {
        this.q_pet = q_pet;
    }

    public int getQ_pet() {
        return q_pet;
    }

    public void setSmoke(int smoke) {
        this.smoke = smoke;
    }

    public int getSmoke() {
        return smoke;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public int getBreakfast() {
        return breakfast;
    }

}
