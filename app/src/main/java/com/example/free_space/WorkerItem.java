package com.example.free_space;

public class WorkerItem {
    private String name;
    private int RoomNum;
    private String Email;
    private int BuildingNum;

    public WorkerItem(String name, int roomNum, String email, int buildingNum) {
        this.name = name;
        RoomNum = roomNum;
        Email = email;
        BuildingNum = buildingNum;
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

    @Override
    public String toString() {
        return "WorkerItem{" +
                "name='" + name + '\'' +
                ", RoomNum=" + RoomNum +
                ", Email='" + Email + '\'' +
                ", BuildingNum=" + BuildingNum +
                '}';
    }
}
