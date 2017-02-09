package com.example.reddyz.basicsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Reddyz on 29-09-2016.
 */
public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";

    static final String TAG="Reddyz-Log";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        Log.i(TAG, "MyDBHandler constructed");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRODUCTNAME + " TEXT " +
                ");";
        Log.i(TAG, "onCreate-Query: "+query);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+ TABLE_PRODUCTS;
        Log.i(TAG, "onUpgrade-Query: "+query);
        db.execSQL(query);
        onCreate(db);
    }

    //Add a new row to db

    public void addProduct(Products prod) {
        Log.i(TAG, "addProduct: "+prod.get_name());
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, prod.get_name());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);
        db.close();
    }

    //Delete a row from db
    public void deleteProduct(String prodName) {
        SQLiteDatabase db = getWritableDatabase();
        Log.i(TAG, "deleteProduct: "+prodName);
        String query = "DELETE from "+ TABLE_PRODUCTS +" WHERE " + COLUMN_PRODUCTNAME +"=\""+prodName+"\";";
        Log.i(TAG, "deleteProduct-Query: "+query);
        db.execSQL(query);
        db.close();
    }

    //Print the db as string
    public String dbToString() {
        String dbString ="";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";

        Log.i(TAG, "dbToString-Query: " +query);

        //Cursor point to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move it to first row in results
        c.moveToFirst();
        String resString;
        while (!c.isAfterLast()) {
            resString = c.getString(c.getColumnIndex(COLUMN_PRODUCTNAME));
            //Log.i(TAG, "dbToString - resString: " +resString);
            if(resString!= null) {
                dbString += resString;
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        Log.i(TAG, "dbToString-Final dbstring: " +dbString);
        return dbString;
    }
}
