package com.nvtr.nhanviensqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.nvtr.nhanviensqlite.model.NhanVien_B18DCCN672;
import com.nvtr.nhanviensqlite.model.ViTri_B18DCCN672;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private  Context context;
    public static final   String DBNAME = "sqlite";
    static final int  DBVERSION = 1;

    public static final   String TABLENV = "nv";

    public static final   String IDNV = "idnv";
    public static final   String NAMENV = "namenv";
    public static final   String DCNV = "dcnv";
    public static final   String NSENV = "nsnv";
    public static final   String TDNV = "tdnv";

    public static final   String TABLEVT = "vt";
    public static final   String IDVT = "idvt";
    public static final   String TENVT = "tenvt";
    public static final   String MOTAEVT = "motavt";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CreatetableN = "CREATE TABLE " + TABLENV +"("
                + IDNV + " INTEGER PRIMARY KEY,"
                + NAMENV + " TEXT,"
                + DCNV + " TEXT,"
                + NSENV + " TEXT,"
                + TDNV + " TEXT )";
        sqLiteDatabase.execSQL(CreatetableN);

        String Createtablevt = "CREATE TABLE " + TABLEVT+"("
                + IDVT + " INTEGER PRIMARY KEY,"
                + TENVT + " TEXT,"
                + MOTAEVT + " TEXT )";
        sqLiteDatabase.execSQL(Createtablevt);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLENV);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLEVT);
        onCreate(sqLiteDatabase);
    }

    public long addNV(NhanVien_B18DCCN672 it) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAMENV, it.getName());
        values.put(DCNV, it.getQuequan());
        values.put(NSENV, it.getNamsinh());
        values.put(TDNV, it.getTrinhdo());
        long res = db.insert(TABLENV, null, values);
        Log.d("Saved!", "saved to DB");
        db.close();
        return res;
    }

    public List<NhanVien_B18DCCN672> getAllNV() {
        List<NhanVien_B18DCCN672> list = new ArrayList<>();
        String query = "SELECT * FROM " + TABLENV;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            NhanVien_B18DCCN672 it = new NhanVien_B18DCCN672(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            list.add(it);
            cursor.moveToNext();
        }
        return list;
    }
    public long addVt(ViTri_B18DCCN672 it) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TENVT, it.getName());
        values.put(MOTAEVT, it.getMota());
        long res = db.insert(TABLEVT, null, values);
        Log.d("Saved!", "saved to DB");
        db.close();
        return res;
    }

    public List<ViTri_B18DCCN672> getAllVt() {
        List<ViTri_B18DCCN672> list = new ArrayList<>();
        String query = "SELECT * FROM " + TABLEVT;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            ViTri_B18DCCN672 it = new ViTri_B18DCCN672(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            list.add(it);
            cursor.moveToNext();
        }
        return list;
    }
}
