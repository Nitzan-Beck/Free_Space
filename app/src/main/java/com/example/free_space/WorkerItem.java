package com.example.free_space;

public class WorkerItem {
    private String name;
    private int RoomNum;
    private String Email;
    private int BuildingNum;
    private String type;


    private String password;

    public WorkerItem() {}

    public WorkerItem(String name, int roomNum, String email, int buildingNum, String type, String pass) {
        this.name = name;
        RoomNum = roomNum;
        Email = email;
        BuildingNum = buildingNum;
        this.type = type;
        this.password = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNum() {
        return RoomNum;
    }

    public void setRoomNum(int roomNum) {
        RoomNum = roomNum;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getBuildingNum() {
        return BuildingNum;
    }

    public void setBuildingNum(int buildingNum) {
        BuildingNum = buildingNum;
    }

    public String gettype() { return type; }

    public void settype(String type) {
        this.type = type;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "WorkerItem{" +
                "name='" + name + '\'' +
                ", RoomNum=" + RoomNum +
                ", Email='" + Email + '\'' +
                ", BuildingNum=" + BuildingNum +
                ", type='" + type + '\'' +
                '}';
    }
}
