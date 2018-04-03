package com.smile.mysupplier;

import android.app.Application;

public class App extends Application {

    public static String API = "http://192.168.43.161/mysupplier/api/v1/";
    public static String URL = "http://192.168.43.161/mysupplier/";

    private static String uniqueID = null;
    private static final String PREF_UNIQUE_ID = "PREF_UNIQUE_ID";

    public static  final int TIMEOUT = 90;

    public static final String LOG = "SURYA";


}
