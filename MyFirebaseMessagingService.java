package com.prakruti.fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by tops123 on 30/11/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService
{

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Intent intent =new Intent(this,MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationbuiler=new NotificationCompat.Builder(this);
        notificationbuiler.setContentTitle("FCM");
        notificationbuiler.setContentText(remoteMessage.getNotification().getBody());
        notificationbuiler.setAutoCancel(true);
        notificationbuiler.setSmallIcon(R.mipmap.ic_launcher);
        notificationbuiler.setContentIntent(pi);
        NotificationManager ni=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        ni.notify(0,notificationbuiler.build());


    }
}
