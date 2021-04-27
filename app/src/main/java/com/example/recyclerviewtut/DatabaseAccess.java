package com.example.recyclerviewtut;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public ArrayList<DishInfo> getImageAndName(){
        ArrayList<DishInfo> dishInfoArrayList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM recipelist",null);
        while(cursor.moveToNext()){
            String nameofdish = cursor.getString(1);
            byte [] imagebytes = cursor.getBlob(2);

            Bitmap objectbitmap = BitmapFactory.decodeByteArray(imagebytes,0,imagebytes.length);
            dishInfoArrayList.add(new DishInfo(nameofdish, objectbitmap));
        }


        return dishInfoArrayList;


    }
    public List<String> getIngredients(String foodname){
        List<String> ingredientsList = new ArrayList<>();
        Log.d("infoss", foodname);
        Cursor cursor = database.rawQuery("SELECT Ingredients FROM ingredients WHERE RecipeName = ?", new String[]{foodname},null);
        while(cursor.moveToNext()){
            String ingredientsStr = cursor.getString(0);
            ingredientsList.add(ingredientsStr);
        }
        return ingredientsList;


    }
}