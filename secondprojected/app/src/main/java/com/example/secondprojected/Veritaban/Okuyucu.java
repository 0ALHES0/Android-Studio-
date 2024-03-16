package com.example.secondprojected.Veritaban;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
public class Okuyucu {
    SQLiteDatabase db;
    TabanHelper thelper;
    public Okuyucu(Context cntx){
        thelper=new TabanHelper(cntx);
        db=thelper.getWritableDatabase();
    }
    public int pcSayiGetir(){
        int sonuc=0;
        Cursor cr=db.rawQuery("select * from PC ",null);
        while (cr.moveToNext()){

            sonuc++;
        }
        return sonuc;
    }
    @SuppressLint("Range")
    public ArrayList<Bilgisayar>  pcleriGetir() {
        ArrayList<Bilgisayar> bilsayarlarList = new ArrayList<Bilgisayar>();
        Cursor cr = db.rawQuery("select * from PC", null);
        while (cr.moveToNext()) {
            Bilgisayar curPC = new Bilgisayar();

            curPC.setEnvno(cr.getInt(cr.getColumnIndex("envno")));
            curPC.setMarka(cr.getString(cr.getColumnIndex("marka")));
            curPC.setModel(cr.getString(cr.getColumnIndex("model")));
            curPC.setIslemci(cr.getString(cr.getColumnIndex("islemci")));
            curPC.setRam(cr.getString(cr.getColumnIndex("ram")));
            curPC.setHdd(cr.getString(cr.getColumnIndex("hdd")));
            curPC.setId(cr.getInt(cr.getColumnIndex("id")));
            bilsayarlarList.add(curPC);

        }

        return bilsayarlarList;
    }

    @SuppressLint("Range")
    public ArrayList<Yazicikayit> yazicileriGetir() {
        ArrayList<Yazicikayit> yaziciList = new ArrayList<Yazicikayit>();
        Cursor cr = db.rawQuery("select * from YAZICI", null);
        while (cr.moveToNext()) {


            Yazicikayit curYazicikayit=new Yazicikayit();
            curYazicikayit.setId(cr.getInt(cr.getColumnIndex("id")));
            curYazicikayit.setEnvno(cr.getInt(cr.getColumnIndex("envno")));
            curYazicikayit.setMarka(cr.getString(cr.getColumnIndex("marka")));
            curYazicikayit.setModel(cr.getString(cr.getColumnIndex("model")));
            curYazicikayit.setDksayfa(cr.getString(cr.getColumnIndex("dksayfa")));
            curYazicikayit.setSbrenkli(cr.getString(cr.getColumnIndex("sbrenkli")));
            yaziciList.add(curYazicikayit);
        }

        return yaziciList;
    }


    @SuppressLint("Range")
    public ArrayList<Tarayıcı> tarayicilariGetir() {
        ArrayList<Tarayıcı> tarayiciList = new ArrayList<Tarayıcı>();
        Cursor cr = db.rawQuery("select * from TARAYICI", null);
        while (cr.moveToNext()) {


            Tarayıcı curTarayıcı=new Tarayıcı();
            curTarayıcı.setId(cr.getInt(cr.getColumnIndex("id")));
            curTarayıcı.setEnvno(cr.getInt(cr.getColumnIndex("envno")));
            curTarayıcı.setMarka(cr.getString(cr.getColumnIndex("marka")));
            curTarayıcı.setModel(cr.getString(cr.getColumnIndex("model")));
            curTarayıcı.setDb(cr.getString(cr.getColumnIndex("dksayfa")));
            curTarayıcı.setMax(cr.getString(cr.getColumnIndex("maxcozunurluk")));
            tarayiciList.add(curTarayıcı);
        }

        return tarayiciList;
    }

    @SuppressLint("Range")
    public ArrayList<Tablet> tabletleriGetir() {
        ArrayList<Tablet> tabletList = new ArrayList<Tablet>();
        Cursor cr = db.rawQuery("select * from TABLET", null);
        while (cr.moveToNext()) {


            Tablet  curTablet=new Tablet();
            curTablet.setId(cr.getInt(cr.getColumnIndex("id")));
            curTablet.setEnvno(cr.getInt(cr.getColumnIndex("envno")));
            curTablet.setMarka(cr.getString(cr.getColumnIndex("marka")));
            curTablet.setModel(cr.getString(cr.getColumnIndex("model")));
            curTablet.setEkrbyt(cr.getString(cr.getColumnIndex("ekranboyut")));
            curTablet.setSrm(cr.getString(cr.getColumnIndex("androidsurum")));
            tabletList.add( curTablet);
        }

        return tabletList;
    }
    @SuppressLint("Range")
    public ArrayList<Kullanıcı> kullanicilariGetir() {
        ArrayList<Kullanıcı> kullanıcıList = new ArrayList<Kullanıcı>();
        Cursor cr = db.rawQuery("select * from KULLANICI", null);
        while (cr.moveToNext()) {


            Kullanıcı  curKullanıcı=new Kullanıcı();
            curKullanıcı.setId(cr.getInt(cr.getColumnIndex("id")));
            curKullanıcı.setAd(cr.getString(cr.getColumnIndex("ad")));
            curKullanıcı.setSoyad(cr.getString(cr.getColumnIndex("soyad")));
            curKullanıcı.setKullaniciadi(cr.getString(cr.getColumnIndex("kullaniciadi")));
            curKullanıcı.setSifre(cr.getString(cr.getColumnIndex("sifre")));
            kullanıcıList.add( curKullanıcı);

        }
        return kullanıcıList;
    }
}
