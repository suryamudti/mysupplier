package com.smile.mysupplier.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.google.gson.Gson;
import com.smile.mysupplier.model.Firebase;
import com.smile.mysupplier.model.Menu;
import com.smile.mysupplier.model.MenuCategory;
import com.smile.mysupplier.model.response.HotMenusByCategory;
import com.smile.mysupplier.model.response.MenuCategories;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hendrigunawan on 07/06/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;


    // database name
    private static final String DATABASE_NANE = "sushiteiDb";

    // table name
    private static final String TABLE_OUTLET_CITY = "outlet_city";
    private static final String TABLE_CITY = "city";
    private static final String TABLE_USER = "user";
    private static final String TABLE_SEAT = "seat";
    private static final String TABLE_MESSAGE = "message";
    private static final String TABLE_MESSAGES = "messages";
    private static final String TABLE_ARTICLE = "article";
    private static final String TABLE_GREETING = "greeting";
    private static final String TABLE_TERM_CONDITION = "termcondition";
    private static final String TABLE_ABOUT_SUSHI_TEI = "aboutsushitei";
    private static final String TABLE_HOT_MENU = "hotmenu";
    private static final String TABLE_HOT_MENU_DETAILS = "hotmenudetails";
    private static final String TABLE_MENU_CATEGORY = "menucategory";
    private static final String TABLE_MENU_CATEGORY_DETAILS = "menucategorydetails";
    private static final String TABLE_PROMO_BANNERS = "promobanner";
    private static final String TABLE_WISHLIST = "wishlist";
    private static final String TABLE_HISTORY_POINT = "historypoint";
    private static final String TABLE_FIREBASE = "firebase";

    // column name
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_RAW = "raw";
    private static final String COLUMN_CREATED_AT = "created_at";
    private static final String COLUMN_CATEGORY = "category";

    private static final String COLUMN_MEMBER_CODE = "member_code";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_FIREBASE_TOKEN = "firebase_token";
    private static final String COLUMN_DOB = "dob";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_CITY_ID = "city_id";
    private static final String COLUMN_POINT = "point";
    private static final String COLUMN_POINT_EXPIRED_AT = "point_expired_at";
    private static final String COLUMN_STATUS = "status";
    private static final String COLUMN_REGISTERED_AT = "registered_at";
    private static final String COLUMN_QRCODE = "qrcode";
    private static final String COLUMN_DEVICE_NUMBER = "device_number";

    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_CODE_VOUCHER = "code_voucher";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";
    private static final String COLUMN_START_DATE = "start_date";
    private static final String COLUMN_END_DATE = "end_date";
    private static final String COLUMN_PUSH_TO = "push_to";
    private static final String COLUMN_UPDATE_AT = "update_at";
    private static final String COLUMN_READ_AT = "read_at";
    private static final String COLUMN_IS_VOUCHER = "is_voucher";
    private static final String COLUMN_IS_USE = "is_use";
    private static final String COLUMN_IS_READ = "is_read";

    private static final String COLUMN_MENU_ID = "menu_id";
    private static final String COLUMN_MENU_CATEGORY = "menu_category";
    private static final String COLUMN_IS_SELECT = "is_select";


    private static final String CREATE_TABLE_OUTLET_CITY = "CREATE TABLE "
            + TABLE_OUTLET_CITY + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_TERM_CONDITION = "CREATE TABLE "
            + TABLE_TERM_CONDITION + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_ABOUT_SUSHI_TEI = "CREATE TABLE "
            + TABLE_ABOUT_SUSHI_TEI + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_GREETING = "CREATE TABLE "
            + TABLE_GREETING + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CATEGORY + " TEXT, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_MEMBER_CODE + " TEXT, "
            + COLUMN_FIRST_NAME + " TEXT, "
            + COLUMN_LAST_NAME + " TEXT, "
            + COLUMN_EMAIL + " TEXT, "
            + COLUMN_IMAGE + " TEXT, "
            + COLUMN_FIREBASE_TOKEN + " TEXT, "
            + COLUMN_DOB + " TEXT, "
            + COLUMN_PHONE + " TEXT, "
            + COLUMN_CITY_ID + " TEXT, "
            + COLUMN_POINT + " INTEGER, "
            + COLUMN_POINT_EXPIRED_AT + " TEXT, "
            + COLUMN_STATUS + " TEXT, "
            + COLUMN_REGISTERED_AT + " TEXT, "
            + COLUMN_QRCODE + " TEXT )";

    private static final String CREATE_TABLE_CITY = "CREATE TABLE "
            + TABLE_CITY + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_SEAT = "CREATE TABLE "
            + TABLE_SEAT + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_MESSAGE = "CREATE TABLE "
            + TABLE_MESSAGE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_MESSAGES = "CREATE TABLE "
            + TABLE_MESSAGES + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT, "
            + COLUMN_DESCRIPTION + " TEXT, "
            + COLUMN_IMAGE + " TEXT, "
            + COLUMN_CODE_VOUCHER + " TEXT, "
            + COLUMN_LATITUDE + " TEXT, "
            + COLUMN_LONGITUDE + " TEXT, "
            + COLUMN_START_DATE + " TEXT, "
            + COLUMN_END_DATE + " TEXT, "
            + COLUMN_PUSH_TO + " TEXT, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp, "
            + COLUMN_UPDATE_AT + " datetime default current_timestamp, "
            + COLUMN_READ_AT + " datetime, "
            + COLUMN_IS_VOUCHER + " INTEGER, "
            + COLUMN_IS_USE + " INTEGER default 0,"
            + COLUMN_IS_READ + " INTEGER default 0)";

    private static final String CREATE_TABLE_ARTICLE = "CREATE TABLE "
            + TABLE_ARTICLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_HOT_MENU_DETAILS = "CREATE TABLE "
            + TABLE_HOT_MENU_DETAILS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CATEGORY + " TEXT, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_MENU_CATEGORY_DETAILS = "CREATE TABLE "
            + TABLE_MENU_CATEGORY_DETAILS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CATEGORY + " TEXT, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_HOT_MENU = "CREATE TABLE "
            + TABLE_HOT_MENU + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_MENU_CATEGORY = "CREATE TABLE "
            + TABLE_MENU_CATEGORY + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_PROMO_BANNER = "CREATE TABLE "
            + TABLE_PROMO_BANNERS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_WISHLIST = "CREATE TABLE "
            + TABLE_WISHLIST + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_MENU_CATEGORY + " TEXT, "
            + COLUMN_MENU_ID + " INTEGER, "
            + COLUMN_IS_SELECT + " INTEGER default 0)";

    private static final String CREATE_TABLE_HISTORY_POINT = "CREATE TABLE "
            + TABLE_HISTORY_POINT + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_RAW + " BLOB, "
            + COLUMN_CREATED_AT + " datetime default current_timestamp)";

    private static final String CREATE_TABLE_FIREBASE = "CREATE TABLE "
            + TABLE_FIREBASE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FIREBASE_TOKEN + " TEXT, "
            + COLUMN_DEVICE_NUMBER + " TEXT) ";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NANE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_OUTLET_CITY);
        db.execSQL(CREATE_TABLE_CITY);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_SEAT);
        db.execSQL(CREATE_TABLE_ARTICLE);
        db.execSQL(CREATE_TABLE_MESSAGE);
        db.execSQL(CREATE_TABLE_MESSAGES);
        db.execSQL(CREATE_TABLE_GREETING);
        db.execSQL(CREATE_TABLE_TERM_CONDITION);
        db.execSQL(CREATE_TABLE_ABOUT_SUSHI_TEI);
        db.execSQL(CREATE_TABLE_HOT_MENU_DETAILS);
        db.execSQL(CREATE_TABLE_HOT_MENU);
        db.execSQL(CREATE_TABLE_MENU_CATEGORY);
        db.execSQL(CREATE_TABLE_PROMO_BANNER);
        db.execSQL(CREATE_TABLE_MENU_CATEGORY_DETAILS);
        db.execSQL(CREATE_TABLE_WISHLIST);
        db.execSQL(CREATE_TABLE_HISTORY_POINT);
        db.execSQL(CREATE_TABLE_FIREBASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OUTLET_CITY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICLE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GREETING);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TERM_CONDITION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ABOUT_SUSHI_TEI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOT_MENU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOT_MENU_DETAILS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROMO_BANNERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU_CATEGORY_DETAILS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WISHLIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY_POINT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FIREBASE);
        onCreate(db);
    }


    /*
    * CRUD Menu Hot Detail List
    * */
    public void createHotMenuDetails(HotMenusByCategory menus, String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HOT_MENU_DETAILS, COLUMN_CATEGORY + " = ?", new String[] { category });

        ContentValues values = new ContentValues();
        values.put(COLUMN_RAW, new Gson().toJson(menus).getBytes());
        values.put(COLUMN_CATEGORY,category);
        db.insert(TABLE_HOT_MENU_DETAILS, null, values);

        db.close();
    }

    public List<Menu> getAllHotMenuDetail(String category){
        List<Menu> menus = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + TABLE_HOT_MENU_DETAILS +" WHERE "+COLUMN_CATEGORY+" = ?", new String[]{category});
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                Gson gson = new Gson();
                HotMenusByCategory menu = gson.fromJson(new String(cursor.getBlob(1)),  HotMenusByCategory.class);
                menus.addAll(menu.getMenus());
            }
            return menus;
        }finally {
            cursor.close();
        }
    }

    public void deleteAlLMenuDetails() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HOT_MENU_DETAILS, null, null);
        db.close();
    }

    /*
    * CRUD Menu Category
    * */
    public void createMenuCategory(MenuCategories menus) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MENU_CATEGORY, null, null);

        ContentValues values = new ContentValues();
        values.put(COLUMN_RAW, new Gson().toJson(menus).getBytes());
        db.insert(TABLE_MENU_CATEGORY, null, values);

        db.close();
    }

    public List<MenuCategory> getAllMenuCategories(){
        List<MenuCategory> menus = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + TABLE_MENU_CATEGORY , null);
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                Gson gson = new Gson();
                MenuCategories menu = gson.fromJson(new String(cursor.getBlob(1)),  MenuCategories.class);
                menus.addAll(menu.getMenuCategories());
            }
            return menus;
        }finally {
            cursor.close();
        }
    }

    public void deleteAlLMenus() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MENU_CATEGORY, null, null);
        db.close();
    }

    /*
    * CRUD Menu Category Details
    * */
    public void createMenuCategoryDetails(HotMenusByCategory menus, String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MENU_CATEGORY_DETAILS, COLUMN_CATEGORY + " = ?", new String[] { category });

        ContentValues values = new ContentValues();
        values.put(COLUMN_RAW, new Gson().toJson(menus).getBytes());
        values.put(COLUMN_CATEGORY,category);
        db.insert(TABLE_MENU_CATEGORY_DETAILS, null, values);

        db.close();
    }

    public List<Menu> getAllMenuCategoriesDetails(String category){
        List<Menu> menus = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + TABLE_MENU_CATEGORY_DETAILS +" WHERE "+COLUMN_CATEGORY+" = ?", new String[]{category});
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                Gson gson = new Gson();
                HotMenusByCategory menu = gson.fromJson(new String(cursor.getBlob(1)),  HotMenusByCategory.class);
                menus.addAll(menu.getMenus());
            }
            return menus;
        }finally {
            cursor.close();
        }
    }

    public void deleteAlLMenuCategoryDetails() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MENU_CATEGORY_DETAILS, null, null);
        db.close();
    }


    /**
     * CRUD FIREBASE
     * @param firebase
     * @return
     */
    public void createFirebase(Firebase firebase){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_FIREBASE, null, null);

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, firebase.getId());
        values.put(COLUMN_FIREBASE_TOKEN, firebase.getFirebaseToken());
        values.put(COLUMN_DEVICE_NUMBER, firebase.getDeviceNumber());

        db.insert(TABLE_FIREBASE, null, values);
        db.close();
    }

    public Firebase getFirebase() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        Firebase firebase = new Firebase();
        try {
            cursor = db.rawQuery("SELECT * FROM " + TABLE_FIREBASE ,null);
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                firebase.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                firebase.setFirebaseToken(cursor.getString(cursor.getColumnIndex(COLUMN_FIREBASE_TOKEN)));
                firebase.setDeviceNumber(cursor.getString(cursor.getColumnIndex(COLUMN_DEVICE_NUMBER)));
            }
            return firebase;
        }finally {
            cursor.close();
        }
    }


}
