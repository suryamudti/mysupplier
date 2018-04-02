package com.smile.mysupplier.util;

import android.app.Application;

public class App extends Application {

    public static String API = "http://103.82.242.42/member/api/v1/";
    public static String URL = "http://103.82.242.42/member/";

    private static String uniqueID = null;
    private static final String PREF_UNIQUE_ID = "PREF_UNIQUE_ID";

    public static  final int TIMEOUT = 90;

    public static final String LOG = "SURYA";


}
