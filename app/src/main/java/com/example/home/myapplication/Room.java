package com.example.home.myapplication;

/**
 * Created by USER on 2018-06-04.
 */

public class Room {
    private String roomname;
    private String roomlocate;
    private String roommoney;

    Room(){}
    Room(String name, String locate, String money){
        this.roomname=name;
        this.roomlocate=locate;
        this.roommoney=money;
    }
    public String getRoomname(){return roomname;}
    public void setRoomname(String name){this.roomname=name;}
    public String getRoomlocate(){return roomlocate;}
    public void setRoomlocate(String locate){this.roomlocate=locate;}
    public String getRoommoney(){return roommoney;}
    public void setRoommoney(String money){this.roommoney=money;}
}
