package com.sujan.break_o_last;

import com.sujan.break_o_last.bll.BookingBill;
import com.sujan.break_o_last.url.BaseUrl;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class RoomBookingTest {
    @Before
    public void setUp() {
        BaseUrl.Base_Url = "http://127.0.1.1:3012/api/v1/";
        BaseUrl.Token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ijk4MTcwOTE3NTciLCJ1c2VybGV2ZWwiOiJzdXBlcmFkbWluIiwiaWF0IjoxNTgwODg2OTIyLCJleHAiOjE1ODA5MjI5MjJ9.gLqKLGYg7WwKhFv5R94EEhBXtjvf016e_36wOa6vQ9w";
    }

    @Test
    public void BookingTest() {
        BookingBill bookingBill = new BookingBill();
        boolean res = bookingBill.getRoomBooked(BaseUrl.Token,"2/6/2020","4");
        assertTrue(res);
    }
}