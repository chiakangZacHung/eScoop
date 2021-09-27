package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class gelatoDataBaseHelper extends SQLiteOpenHelper{
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_QUANTITY = "CUSTOMER_QUANTITY";
    public static final String COLUMN_ID = "ID";

    public gelatoDataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    //create table first time database is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "Create TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + " TEXT, " + COLUMN_CUSTOMER_QUANTITY + " INT)";
        db.execSQL(createTableStatement);


    }
    //when update table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(gelatoCustomerModel customerModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_CUSTOMER_NAME, customerModel.getName());
        cv.put(COLUMN_CUSTOMER_QUANTITY, customerModel.getQuantity());

        long insert=db.insert(CUSTOMER_TABLE,null,cv);
        if(insert==-1)
            return false;
        else
            return true;
    }
    public boolean DeleteOne(gelatoCustomerModel customerModel){
        SQLiteDatabase db=this.getWritableDatabase();
        String queryString="DELETE FROM "+CUSTOMER_TABLE+" WHERE "+COLUMN_ID+"="+customerModel.getId();
        Cursor cursor=db.rawQuery(queryString,null);
        if(cursor.moveToFirst()) {
            return true;
        }
        else{
            return false;
        }
    }

    public List<gelatoCustomerModel> getEveryOne(){
        List<gelatoCustomerModel> returnList=new ArrayList<>();
        String queryString="SELECT * FROM " +CUSTOMER_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()) {
            do {
                int customerID=cursor.getInt(0);
                String customerName=cursor.getString(1);
                int customerQuantity= cursor.getInt(2);
                boolean customerActive=cursor.getInt(3)==1 ? true: false;

                gelatoCustomerModel newCustomer=new gelatoCustomerModel(customerID,customerName,customerQuantity);
                returnList.add(newCustomer);
            } while (cursor.moveToNext());
        }
        else{

        }

        return returnList;

    }
}
