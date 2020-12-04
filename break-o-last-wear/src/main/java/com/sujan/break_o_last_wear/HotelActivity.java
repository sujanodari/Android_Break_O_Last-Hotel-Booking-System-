package com.sujan.break_o_last_wear;

import android.app.Notification;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelActivity extends WearableActivity {

    public static ArrayList<Hotel> hotelList;
    private TextView hotel;
    int booked;
    String book;
    NotificationManagerCompat notificationManagerCompat;

    Broadcast broadcast;

    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        hotel= findViewById(R.id.hotel);
        getHotel();
        broadcast = new Broadcast();
        notificationManagerCompat = NotificationManagerCompat.from(this);
        Channel channel = new Channel(this);
        channel.createChannel();
        displayNotification();
         book="Total number of  Booked rooms: "+String.valueOf(booked);
        hotel.setText(book);


        setAmbientEnabled();
    }
    private void displayNotification() {
        Notification notification = new NotificationCompat.Builder(this, Channel.channel_2)
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setContentTitle("No of Room Booked: "+booked)
                .setContentText( book)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);


    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcast,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcast);
    }

    public void getHotel() {
        StrictModeClass.StrictMode();
        HotelBll hotelBll = new HotelBll();
        hotelBll.getHotel();
        HashMap<String, Integer> frequencymap = new HashMap<String, Integer>();
         booked =hotelList.size();

    }

}
