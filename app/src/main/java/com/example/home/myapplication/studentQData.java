package com.example.home.myapplication;

public class studentQData {
    String Q_school;//학교이름
    String liveWith;//누구랑 같이 살지 Granny Granpa Old couple
    String houseType;// house type- Detached house /Apartments/Row Houses/Multi-Family Housing
    int q_period;//length of stay-4/6/6~
    int q_money;//원하는 가격- 150,000/200,000/250,000/300,000
    int q_bill;//공과금 30,000/50,000/no

    studentQData(String Q_school,String liveWith,String houseType,int q_period,int q_money,int q_bill){
        this.Q_school=Q_school;
        this.liveWith=liveWith;
        this.houseType=houseType;
        this.q_period=q_period;
        this.q_money=q_money;
        this.q_bill=q_bill;

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


}
