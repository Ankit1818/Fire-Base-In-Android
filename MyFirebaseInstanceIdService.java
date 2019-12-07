package com.prakruti.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by tops123 on 30/11/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService
{
    private static final String REG_TOKEN="REG_TOKEN";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token= FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,token);
    }
}
