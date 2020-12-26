package com.example.free_space;

public class WorkerItem {
    private String name;
    private int RoomNum;
    private String Email;

    public WorkerItem(String name, int roomNum, String email) {
        this.name = name;
       this.RoomNum = roomNum;
        this.Email = email;
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

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", RoomNum=" + RoomNum +
                ", Email='" + Email + '\'' +
                '}';
    }
}
