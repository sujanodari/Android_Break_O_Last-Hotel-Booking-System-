package com.sujan.break_o_last.models;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name,address;
    private int imageId;

    static List<Hotel> hotelList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<Hotel> getHotelList() {
        return hotelList;
    }

    public static void setHotelList(List<Hotel> hotelList) {
        Hotel.hotelList = hotelList;
    }

    public Hotel(String name, String address, int imageId) {
        this.name = name;
        this.address = address;
        this.imageId = imageId;
    }


}
