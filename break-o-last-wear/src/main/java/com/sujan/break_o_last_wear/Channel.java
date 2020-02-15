package com.sujan.break_o_last_wear;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class Channel {

    Context context;
    static final String channel_1="Channel1";
    static final String channel_2="Channel2";

    public Channel(Context context) {
        this.context = context;
    }

    public void createChannel(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){

            NotificationChannel channel1 = new NotificationChannel(
                    channel_1,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_LOW
            );

            channel1.setDescription("This is channel 1");

            NotificationChannel channel2 = new NotificationChannel(
                    channel_2,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_HIGH
            );

            channel1.setDescription("This is channel 2");

            NotificationManager manager= context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);


        }
    }
}
