package com.example.infobucharest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String CUSTOMER_PHONE = "CUSTOMER_PHONE";
    public static final String CUSTOMER_EMAIL = "CUSTOMER_EMAIL";
    public static final String CUSTOMER_PASSWORD = "CUSTOMER_PASSWORD";

    public DataBase(@Nullable Context context) {
        super(context, "bucInfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME + " TEXT, " + CUSTOMER_PHONE + " INT, " + CUSTOMER_EMAIL + " TEXT, " + CUSTOMER_PASSWORD + " TEXT)";

        sqLiteDatabase.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(AccountsModel accountsModel){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CUSTOMER_NAME, accountsModel.getFirstName());
        cv.put(CUSTOMER_PHONE, accountsModel.getPhoneNumber());
        cv.put(CUSTOMER_EMAIL, accountsModel.getEmailAddress());
        cv.put(CUSTOMER_PASSWORD, accountsModel.getPassword());

        long insert = sqLiteDatabase.insert(CUSTOMER_TABLE, null, cv);
        return insert != -1;
    }

}
