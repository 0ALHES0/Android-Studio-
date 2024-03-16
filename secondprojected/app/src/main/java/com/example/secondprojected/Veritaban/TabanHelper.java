package com.example.secondprojected.Veritaban;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TabanHelper extends SQLiteOpenHelper {

    public TabanHelper(@Nullable Context context) {
        super(context, "EnvanterDB_5.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qq1="CREATE TABLE PC("+
                "id"+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "envno"+" INTEGER , "+
                "marka"+" TEXT,"+
                "model"+" TEXT,"+
                "islemci"+" TEXT,"+
                "ram"+" TEXT,"+
                "hdd"+" TEXT"

                +")";
        db.execSQL(qq1);

        String qq2="CREATE TABLE TABLET("+
                "id"+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "envno"+" INTEGER , "+
                "marka"+" TEXT,"+
                "model"+" TEXT,"+
                "ekranboyut"+" TEXT,"+
                "androidsurum"+" TEXT"


                +")";
        db.execSQL(qq2);

        String qq3="CREATE TABLE YAZICI("+
                "id"+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "envno"+" INTEGER , "+
                "marka"+" TEXT,"+
                "model"+" TEXT,"+
                "dksayfa"+" TEXT,"+
                "sbrenkli"+" TEXT"


                +")";
        db.execSQL(qq3);
        String qq4="CREATE TABLE TARAYICI("+
                "id"+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "envno"+" INTEGER , "+
                "marka"+" TEXT,"+
                "model"+" TEXT,"+
                "dksayfa"+" TEXT,"+
                "maxcozunurluk"+" TEXT"

                +")";
        db.execSQL(qq4);

        String qq5="CREATE TABLE KULLANICI("+
                "id"+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "ad"+" TEXT  , "+
                "soyad"+" TEXT,"+
                "kullaniciadi"+" TEXT,"+
                "sifre"+" TEXT"

                +")";
        db.execSQL(qq5);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
