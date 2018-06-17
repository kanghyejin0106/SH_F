package com.example.home.myapplication;

public class studentQData {
    String Q_school;//학교이름
    String liveWith;//누구랑 같이 살지 Granny Granpa Old couple
    String houseType;// house type- Detached house /Apartments/Row Houses/Multi-Family Housing
    int q_period;//length of stay-4/6/6~
    int q_money;//원하는 가격- 150,000/200,000/250,000/300,000
    int q_bill;//공과금 30,000/50,000/no
    int q_religion;//종교 1. Christianity 2. Budhism 3. Catholic 4. Islam 5. No Religion
    int q_pet;//반려동물 1. 기르고 있으며 상관없 2.기르지 않으나 상관없 3. 싫어함
    int smoke;//1. always 2.often 3.Sometimes 4. Do not
    int alcohol;//1.always 2. often 3. Sometimes 4.Do not
    int breakfast;//1.I always eat 2.eat often 3. i eat sometimes 4.Do not eat
    int invite;//1.once a month 2. once every two month 3.once every three month 4. do not
    studentQData(String Q_school,String liveWith,String houseType,int q_period,int q_money,int q_bill,int q_religion,int q_pet,
    int smoke,int alcohol,int breakfast, int invite){
        this.Q_school=Q_school;
        this.liveWith=liveWith;
        this.houseType=houseType;
        this.q_period=q_period;
        this.q_money=q_money;
        this.q_bill=q_bill;
        this.q_religion=q_religion;
        this.q_pet=q_pet;
        this.smoke=smoke;
        this.alcohol=alcohol;
        this.breakfast=breakfast;
        this.invite=invite;
    }

    public void setLiveWith(String liveWith) {
        this.liveWith = liveWith;
    }

    public String getLiveWith() {
        return liveWith;
    }

    public void setQ_school(String q_school) {
        Q_school = q_school;
    }

    public String getQ_school() {
        return Q_school;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseType() {
        return houseType;
    }
    public void setQ_period(int q_period) {
        this.q_period = q_period;
    }

    public int getQ_period() {
        return q_period;
    }

    public void setQ_money(int q_money) {
        this.q_money = q_money;
    }

    public int getQ_money() {
        return q_money;
    }

    public void setQ_bill(int q_bill) {
        this.q_bill = q_bill;
    }

    public int getQ_bill() {
        return q_bill;
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

    public void setInvite(int invite) {
        this.invite = invite;
    }

    public int getInvite() {
        return invite;
    }
}
