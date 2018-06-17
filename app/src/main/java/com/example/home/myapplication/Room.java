package com.example.home.myapplication;

/**
 * Created by USER on 2018-06-04.
 */

public class Room {
    private String roomname;
    private String roomlocate;
    private String roomMoney;
    private String img1FilePath;
    private String img2FilePath;
    private String img3FIlePath;
    private String img4FilePath;


    Room(){}
    Room(String name, String locate, String roomMoney,String img1FilePath,String img2FilePath,String img3FIlePath,String img4FilePath){
        this.img1FilePath=img1FilePath;
        this.img2FilePath=img2FilePath;
        this.img3FIlePath=img3FIlePath;
        this.img4FilePath=img4FilePath;
        this.roomname=name;
        this.roomlocate=locate;
        this.roomMoney=roomMoney;
    }
    public String getroomname(){return roomname;}
    public void setroomname(String name){this.roomname=name;}
    public String getroomlocate(){return roomlocate;}
    public void setroomlocate(String locate){this.roomlocate=locate;}
    public String getroommoney(){return roomMoney;}
    public void setroommoney(String money){this.roomMoney=money;}

    public String getImg1FilePath(){return img1FilePath;}
    public void setImg1FilePath(String img1path){this.img1FilePath=img1path;}
    public String getImg2FilePath(){return img2FilePath;}
    public void setImg2FilePath(String img2path){this.img2FilePath=img2path;}
    public String getImg3FilePath(){return img3FIlePath;}
    public void setImg3FilePath(String img3path){this.img3FIlePath=img3path;}
    public String getImg4FilePath(){return img4FilePath;}
    public void setImg4FilePath(String img4path){this.img4FilePath=img4path;}
}

