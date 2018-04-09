package com.smile.mysupplier;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class App extends Application {

//    public static String API = "http://192.168.43.161/mysupplier/api/v1/";
//    public static String URL = "http://192.168.43.161/mysupplier/";


    public static String API = "http://10.0.0.82/mysupplier/api/v1/";
    public static String URL = "http://10.0.0.82/mysupplier/";

    private static String uniqueID = null;
    private static final String PREF_UNIQUE_ID = "PREF_UNIQUE_ID";

    public static  final int TIMEOUT = 90;

    public static final String LOG = "SURYA";

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/latoRegular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }


}
