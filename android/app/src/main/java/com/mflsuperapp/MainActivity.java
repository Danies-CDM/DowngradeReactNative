package com.mflsuperapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.adobe.marketing.mobile.MobileCore;
import com.clevertap.android.sdk.CleverTapAPI;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import com.swmansion.gesturehandler.react.RNGestureHandlerEnabledRootView;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.devio.rn.splashscreen.SplashScreen;

import com.appsflyer.AppsFlyerLib;
import com.clevertap.react.CleverTapModule;

import java.util.Objects;

public class MainActivity extends ReactActivity {
    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "mflsuperapp";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        SplashScreen.show(this, R.style.SplashTheme, true);
        super.onCreate(null);
        CleverTapModule.setInitialUri(getIntent().getData());
        AppsFlyerLib.getInstance().init("WgbFW23FtqitT9twpBozVP", null, this);
        AppsFlyerLib.getInstance().start(this);
    }

    @Override
    public void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        /**
         * On Android 12, Raise notification clicked event when Activity is already running in activity backstack
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            CleverTapAPI.getDefaultInstance(getApplicationContext()).pushNotificationClickedEvent(intent.getExtras());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MobileCore.setApplication(getApplication());
        MobileCore.lifecycleStart(null);
    }
    // AppsFlyerLib.getInstance().init("WgbFW23FtqitT9twpBozVP", null, this);
    // AppsFlyerLib.getInstance().start(this,"WgbFW23FtqitT9twpBozV",null);

//    @Override
//    protected ReactActivityDelegate createReactActivityDelegate() {
//        return new ReactActivityDelegate(this, getMainComponentName()) {
//            @Override
//            protected ReactRootView createRootView() {
//                return new RNGestureHandlerEnabledRootView(MainActivity.this);
//            }
//        };
//    }

    //    @Override
//    protected ReactActivityDelegate createReactActivityDelegate() {
//        return new DefaultReactActivityDelegate(
//                this,
//                getMainComponentName(),
//                // If you opted-in for the New Architecture, we enable the Fabric Renderer.
            //    DefaultNewArchitectureEntryPoint.getFabricEnabled(), // fabricEnabled
//                // If you opted-in for the New Architecture, we enable Concurrent React (i.e. React 18).
//                DefaultNewArchitectureEntryPoint.getConcurrentReactEnabled() // concurrentRootEnabled
//        );
//    }
    @Override
    public void onPause() {
        super.onPause();
        MobileCore.lifecyclePause();
    }
}
