package com.example.secondprojected;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.secondprojected.Veritaban.Kullanıcı;
import com.example.secondprojected.Veritaban.Okuyucu;
import com.example.secondprojected.Veritaban.Yazici;

import java.util.ArrayList;

public class KullanicListeActivity extends AppCompatActivity {
    LinearLayout hareketlerAnaLayout;
    Okuyucu okc;
    Yazici yzc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanic_liste);
        yzc=new Yazici(KullanicListeActivity.this);
        okc=new Okuyucu(KullanicListeActivity.this);
        hareketlerAnaLayout=(LinearLayout) findViewById(R.id.hareketlerAnaLinearlayout);

        ArrayList<Kullanıcı> kullanıcıListesi=okc.kullanicilariGetir();

        LinearLayout.LayoutParams hrkHorizantalLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        hrkHorizantalLayoutParams.gravity= Gravity.CENTER_VERTICAL;
        LinearLayout.LayoutParams vievLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vievLayoutParams.setMargins(0,0,0,20);
        LinearLayout.LayoutParams vievsLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vievsLayoutParams.setMargins(0,0,0,70);
        for (int n=0;n<kullanıcıListesi.size();n++) {

            Kullanıcı  curKullanıcı=kullanıcıListesi.get(n);

            LinearLayout curklcLayout = new LinearLayout(this);
            curklcLayout.setOrientation(LinearLayout.VERTICAL);
            curklcLayout.setLayoutParams(hrkHorizantalLayoutParams);
            curklcLayout.setPadding(10, 10, 10, 10);

            TextView envnoTextView = new TextView(this);
            envnoTextView.setText(String.valueOf("Ad:       "+curKullanıcı.getAd()));
            envnoTextView.setTextSize(20);
            envnoTextView.setTextColor(Color.WHITE);
            envnoTextView.setBackground(getDrawable(R.drawable.azoval));
            envnoTextView.setPadding(25, 25, 25, 25);
            envnoTextView.setLayoutParams(vievLayoutParams);
            curklcLayout.addView(envnoTextView);

            TextView mmTextView = new TextView(this);
            mmTextView.setText("Soyad:        "+curKullanıcı.getSoyad());
            mmTextView.setBackground(getDrawable(R.drawable.azoval));
            mmTextView.setTextSize(20);
            mmTextView.setTextColor(Color.WHITE);
            mmTextView.setLayoutParams(vievLayoutParams);
            mmTextView.setPadding(25, 25, 25, 25);

            curklcLayout.addView(mmTextView);

            TextView mdlTextView = new TextView(this);
            mdlTextView.setText("Kullanıcı Adı:        "+curKullanıcı.getKullaniciadi());
            mdlTextView.setBackground(getDrawable(R.drawable.azoval));
            mdlTextView.setTextSize(20);
            mdlTextView.setTextColor(Color.WHITE);
            mdlTextView.setLayoutParams(vievLayoutParams);
            mdlTextView.setPadding(25, 25, 25, 25);

            curklcLayout.addView(mdlTextView);

            TextView ozTextView = new TextView(this);
            ozTextView.setText("Şifre:      "+curKullanıcı.getSifre());
            ozTextView.setBackground(getDrawable(R.drawable.azoval));
            ozTextView.setTextSize(20);
            ozTextView.setTextColor(Color.WHITE);
            ozTextView.setLayoutParams(vievLayoutParams);
            ozTextView.setPadding(25, 25, 25, 25);

            curklcLayout.addView(ozTextView);




            Button silButon = new Button(this);
            silButon.setText("Sil");
            silButon.setTextSize(20);
            silButon.setBackground(getDrawable(R.drawable.beyaz));
            silButon.setPadding(25, 25, 25, 25);
            silButon.setLayoutParams(vievsLayoutParams);




            silButon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        /*yzc.pcSil(curBilgisayar.getId());
                        hareketlerAnaLayout.invalidate();
                        Intent intt=new Intent(PcListeActivity.this,PcListeActivity.class);
                        startActivity(intt);
                        Toast.makeText(PcListeActivity.this, "Silme Başarılı", Toast.LENGTH_SHORT).show();*/
                    final AlertDialog.Builder builder = new AlertDialog.Builder(KullanicListeActivity.this);
                    builder.setTitle("Uyarı !!!");
                    builder.setMessage("Silmek istediğinizden Emin misiniz ?"  );
                    builder.setIcon(android.R.drawable.ic_menu_delete);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            yzc.kllncSil(curKullanıcı.getId());
                            hareketlerAnaLayout.invalidate();
                            Intent intt=new Intent(KullanicListeActivity.this,KullanicListeActivity.class);
                            startActivity(intt);
                        }
                    });
                    builder.setNegativeButton("Hayır",null);
                    builder.show();
                }
            });

            curklcLayout.addView(silButon);

            hareketlerAnaLayout.addView(curklcLayout);

        }
    }
}