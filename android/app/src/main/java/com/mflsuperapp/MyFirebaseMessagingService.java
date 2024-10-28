package com.mflsuperapp;

import android.util.Log;

import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.pushnotification.fcm.CTFcmMessageHandler;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.appsflyer.AppsFlyerLib;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage message) {
        try {
            if (message.getData().containsKey("af-uninstall-tracking")) { // "uninstall" is not a typo
                return;
            } else {
                // handleNotification(remoteMessage);
                new CTFcmMessageHandler().createNotification(getApplicationContext(), message);
            }

        } catch (Throwable t) {
            Log.d("MYFCMLIST", "Error parsing FCM message", t);
        }
    }

    @Override
    public void onNewToken(String token) {
        Log.d("MYFCMTOKEN", "Generated FCM Token " + token);
        CleverTapAPI.getDefaultInstance(this).pushFcmRegistrationId(token, true);
        AppsFlyerLib.getInstance().updateServerUninstallToken(getApplicationContext(), token);
    }
}
