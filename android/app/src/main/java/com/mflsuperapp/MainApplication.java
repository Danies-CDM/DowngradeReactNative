package com.mflsuperapp;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.adobe.marketing.mobile.Analytics;
import com.adobe.marketing.mobile.Assurance;
import com.adobe.marketing.mobile.Identity;
import com.adobe.marketing.mobile.InvalidInitException;
import com.adobe.marketing.mobile.Lifecycle;
import com.adobe.marketing.mobile.MobileCore;
import com.adobe.marketing.mobile.Signal;
import com.adobe.marketing.mobile.UserProfile;
import com.adobe.marketing.mobile.WrapperType;
import com.airbnb.android.react.lottie.LottiePackage;
import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.android.sdk.CleverTapAPI;

import com.clevertap.android.pushtemplates.PushTemplateNotificationHandler;
import com.clevertap.android.sdk.interfaces.NotificationHandler;

import com.clevertap.android.sdk.interfaces.OnInitCleverTapIDListener;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.reactlibrary.ymchat.YMChatPackage;

import org.devio.rn.splashscreen.SplashScreenReactPackage;

import com.facebook.react.defaults.DefaultReactNativeHost;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.codepush.react.CodePush;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.soloader.SoLoader;
//import com.swmansion.reanimated.ReanimatedJSIModulePackage;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFInAppEventParameterName;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost =
//            new ReactNativeHost(this) {
//                @Override
//                public boolean getUseDeveloperSupport() {
//                    return BuildConfig.DEBUG;
//                }
//
//                @Override
//                protected List<ReactPackage> getPackages() {
//                    @SuppressWarnings("UnnecessaryLocalVariable")
//                    List<ReactPackage> packages = new PackageList(this).getPackages();
//                    packages.add(new LottiePackage());
//                    return packages;
//                }
//
//                @Override
//                protected String getJSMainModuleName() {
//                    return "index";
//                }
//
//                @Override
//                protected JSIModulePackage getJSIModulePackage() {
//                    return new ReanimatedJSIModulePackage();
//                }
//
//                // 2. Override the getJSBundleFile method in order to let
//                // the CodePush runtime determine where to get the JS
//                // bundle location from on each app start
//                @Override
//                protected String getJSBundleFile() {
//                    return CodePush.getJSBundleFile();
//                }
//            };

            new DefaultReactNativeHost(this) {
                @Override
                public boolean getUseDeveloperSupport() {
                    return BuildConfig.DEBUG;
                }

                @Override
                protected List<ReactPackage> getPackages() {
                    List<ReactPackage> packages = new PackageList(this).getPackages();
                    packages.add(new LottiePackage());
                    return packages;
                }

                protected String getJSMainModuleName() {
                    return "index";
                }

                @Override
                protected boolean isNewArchEnabled() {
                    return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
                }

                @Override
                protected Boolean isHermesEnabled() {
                    return BuildConfig.IS_HERMES_ENABLED;
                }

                // 2. Override the getJSBundleFile method in order to let
                // the CodePush runtime determine where to get the JS
                // bundle location from on each app start
                @Override
                protected String getJSBundleFile() {
                    return CodePush.getJSBundleFile();
                }

//        @Override
//        protected JSIModulePackage getJSIModulePackage() {
//            return new ReanimatedJSIModulePackage();
//        }

            };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }


    @Override
    public void onCreate() {
        CleverTapAPI clevertapDefaultInstance = null;
        clevertapDefaultInstance = Objects.requireNonNull(CleverTapAPI.getDefaultInstance(getApplicationContext()));
        // CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.VERBOSE);
        CleverTapAPI.setNotificationHandler((NotificationHandler) new PushTemplateNotificationHandler());
        // you can use below two xiaomi related methods from clevertap-react-native 0.9.0 onwards
        //CleverTapAPI.changeXiaomiCredentials("your xiaomi app id","your xiaomi app key")
        //CleverTapAPI.enableXiaomiPushOn(XIAOMI_MIUI_DEVICES)
        //CleverTapAPI.setNotificationHandler((NotificationHandler) new PushTemplateNotificationHandler());
        clevertapDefaultInstance.enableDeviceNetworkInfoReporting(true);
        //CleverTapAPI.getDefaultInstance(getApplicationContext()).setCTPushNotificationListener((CTPushNotificationListener) this);
        // Register the CleverTap ActivityLifecycleCallback; before calling super
        ActivityLifecycleCallback.register(this);

        FirebaseAnalytics mFirebaseAnalytics;
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        // String ctId=clevertapDefaultInstance.getCleverTapID();
        // mFirebaseAnalytics.setUserProperty("ct_objectId", ctId);
        clevertapDefaultInstance.getCleverTapID(new OnInitCleverTapIDListener() {
            @Override
            public void onInitCleverTapID(final String cleverTapID) {
                // Callback on main thread
                System.out.println("CleverTap_ID: "+cleverTapID);
                if(cleverTapID!=null)
                {
                    mFirebaseAnalytics.setUserProperty("ct_objectId", cleverTapID);
                }
            }
        });

        super.onCreate();
        AppsFlyerLib.getInstance().init("WgbFW23FtqitT9twpBozVP", null, this);
        AppsFlyerLib.getInstance().start(this);
        // AppsFlyerLib.getInstance().setDebugLog(true);
        // Map<String, Object> eventParameters0 = new HashMap<String, Object>();
        // eventParameters0.put(AFInAppEventParameterName.REGSITRATION_METHOD, "");
        // AppsFlyerLib.getInstance().logEvent(getApplicationContext(), AFInAppEventType.COMPLETE_REGISTRATION, eventParameters0);
        // AppsFlyerLib.getInstance().logEvent(getApplicationContext(), AFInAppEventType.LOGIN, null);
        SoLoader.init(this, /* native exopackage */ false);
        // initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
        initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
        MobileCore.setApplication(this);
        MobileCore.setWrapperType(WrapperType.REACT_NATIVE);
        // MobileCore.setLogLevel(LoggingMode.VERBOSE);
        try {
            Assurance.registerExtension();
            Analytics.registerExtension();
            Identity.registerExtension();
            Lifecycle.registerExtension();
            Signal.registerExtension();
            UserProfile.registerExtension();
            // MobileCore.start(o -> MobileCore.configureWithAppID("a3d08833fce3/84c5db111d73/launch-7e0f42bed31e-development"));
            // MobileCore.start(o -> MobileCore.configureWithAppID("a3d08833fce3/84c5db111d73/launch-df67c752db8f"));
            MobileCore.start(o -> MobileCore.configureWithAppID(getString(R.string.adobe_key)));
        } catch (InvalidInitException e) {
        }

//        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
//            @Override
//            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//
//            }
//
//            @Override
//            public void onActivityStarted(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityResumed(Activity activity) {
//               // MobileCore.setApplication(MainApplication.this);
//                MobileCore.lifecycleStart(null);
//
////                HashMap<String, String> additionalContextData = new HashMap<String, String>();
////                additionalContextData.put("myapp.category", "Abfrl mobile app"); // need to pass platform key-value here.
////                MobileCore.lifecycleStart(additionalContextData);
//            }
//
//            @Override
//            public void onActivityPaused(Activity activity) {
//                MobileCore.lifecyclePause();
//            }
//
//            @Override
//            public void onActivityStopped(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
//
//            }
//
//            @Override
//            public void onActivityDestroyed(Activity activity) {
//
//            }
//        });
    }

    /**
     * Loads Flipper in React Native templates. Call this in the onCreate method with something like
     * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
     *
     * @param context
     * @param reactInstanceManager
     */
    private static void initializeFlipper(
            Context context, ReactInstanceManager reactInstanceManager) {
        if (BuildConfig.DEBUG) {
            try {
        /*
         We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
                Class<?> aClass = Class.forName("com.mflsuperapp.ReactNativeFlipper");
                aClass
                        .getMethod("initializeFlipper", Context.class, ReactInstanceManager.class)
                        .invoke(null, context, reactInstanceManager);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}

