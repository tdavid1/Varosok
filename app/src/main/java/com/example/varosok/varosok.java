package com.example.varosok;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class varosok extends SQLiteOpenHelper {
    private static final String db_name = "varosok.dp";
    private  static  final int db_version = 1;
    private static final String Table_Name = "varosok";
    private static final String Col_Id = "id";
    private static final String Col_Nev = "nev";
    private static final String Col_Orszag = "orszag";
    private static final String Col_Lakossag = "lakosag";

    public varosok(Context context){
        super(context,db_name,null,db_version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String sql = "Create TABLE " + Table_Name + " (" + Col_Id  + " INTEGER Primary Key AUTOINCREMENT, " + Col_Nev + " Text not null," +
                Col_Orszag + " Text not null," + Col_Lakossag + " Integer not null" + ");";
        sqLiteDatabase.execSQL(sql);
    }
    @Override
    public  void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL(
                "DROP TABLE IF EXISTS " + Table_Name
        );
        onCreate(sqLiteDatabase);
    }
    public Cursor adatlekerdezes(){
        SQLiteDatabase database = this.getReadableDatabase();
        return database.query(Table_Name,new String[]{Col_Id,Col_Nev,Col_Orszag,Col_Lakossag},null,null,null,null,null);
    }
    public boolean adatRogzites(String Nev,String Orszag, int Lakossag){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col_Nev, Nev);
        values.put(Col_Orszag, Orszag);
        values.put(Col_Lakossag, Lakossag);
        long result = database.insert(Table_Name, null, values);
        return result !=-1;
    }
}

