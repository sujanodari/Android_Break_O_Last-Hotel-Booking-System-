package com.sujan.break_o_last_wear;

public class Hotel {
    String id, userId, hotelId, Date;

    public Hotel(String id, String userId, String hotelId, String date) {
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
        Date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
