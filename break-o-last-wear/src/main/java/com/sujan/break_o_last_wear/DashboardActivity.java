package com.sujan.break_o_last_wear;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    public static List<Hotel> hotelList = new ArrayList<>();
    TextView hotel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        hotel= findViewById(R.id.hotel);
        StrictModeClass.StrictMode();
        HotelBll hotelBll = new HotelBll();
        hotelBll.getHotel();
        hotel.setText(String.valueOf(hotelList));

    }
}
