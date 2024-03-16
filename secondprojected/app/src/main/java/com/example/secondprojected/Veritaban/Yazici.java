package com.example.secondprojected.Veritaban;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Yazici {
    SQLiteDatabase db;
    TabanHelper thelper;

    public Yazici(Context cntx) {
        thelper = new TabanHelper(cntx);
        db = thelper.getWritableDatabase();
    }

    public boolean bilgisayarKaydet(int envno, String markatxt, String modeltxt, String islemci, String ram, String hdd) {
        boolean basari = false;
        try {
            ContentValues cv = new ContentValues();
            cv.put("envno", envno);
            cv.put("marka", markatxt);
            cv.put("model", modeltxt);
            cv.put("islemci", islemci);
            cv.put("ram", ram);
            cv.put("hdd", hdd);
            db.insert("PC", null, cv);
            basari = true;
        } catch (Exception e) {

        }
        return basari;
    }

    public boolean yaziciKaydet(int envno1, String marka, String model, String dks, String sb) {
        boolean basari1 = false;
        try {
            ContentValues cv = new ContentValues();
            cv.put("envno", envno1);
            cv.put("marka", marka);
            cv.put("model", model);
            cv.put("dksayfa", dks);
            cv.put("sbrenkli", sb);

            db.insert("YAZICI", null, cv);
            basari1 = true;
        } catch (Exception e) {

        }
        return basari1;
    }
    public boolean tarayiciKaydet(int envno1, String marka, String model, String dks, String max) {
        boolean basari2 = false;
        try {
            ContentValues cv = new ContentValues();
            cv.put("envno", envno1);
            cv.put("marka", marka);
            cv.put("model", model);
            cv.put("dksayfa", dks);
            cv.put("maxcozunurluk", max);

            db.insert("TARAYICI", null, cv);
            basari2 = true;
        } catch (Exception e) {

        }
        return basari2;
    }
    public boolean tabletKaydet(int envno1, String marka, String model, String ekrbyt, String srm) {
        boolean basari2 = false;
        try {
            ContentValues cv = new ContentValues();
            cv.put("envno", envno1);
            cv.put("marka", marka);
            cv.put("model", model);
            cv.put("ekranboyut", ekrbyt);
            cv.put("androidsurum", srm);

            db.insert("TABLET", null, cv);
            basari2 = true;
        } catch (Exception e) {

        }
        return basari2;
    }
    public boolean kullaniciKaydet(String adi, String soyadi, String kul_adi, String sifre) {
        boolean basari2 = false;
        try {
            ContentValues cv = new ContentValues();
            cv.put("ad", adi);
            cv.put("soyad", soyadi);
            cv.put("kullaniciadi", kul_adi);
            cv.put("sifre", sifre);

            db.insert("KULLANICI", null, cv);
            basari2 = true;
        } catch (Exception e) {

        }
        return basari2;
    }
    @SuppressLint("Range")
    public void pcSil(int pcid) {
        db.execSQL("Delete from PC where id="+pcid);
    }
    @SuppressLint("Range")
    public void yzcSil(int yzcid) {
        db.execSQL("Delete from YAZICI where id="+yzcid);
    }
    @SuppressLint("Range")
    public void trycSil(int trycid) {
        db.execSQL("Delete from TARAYICI where id="+trycid);
    }
    @SuppressLint("Range")
    public void tbltSil(int tbltid) {
        db.execSQL("Delete from TABLET where id="+tbltid);
    }
    @SuppressLint("Range")
    public void kllncSil(int kllncid) {
        db.execSQL("Delete from KULLANICI where id="+kllncid);
    }
}