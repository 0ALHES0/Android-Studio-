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

import com.example.secondprojected.Veritaban.Okuyucu;
import com.example.secondprojected.Veritaban.Yazici;
import com.example.secondprojected.Veritaban.Yazicikayit;

import java.util.ArrayList;

public class YazicilisteActivity extends AppCompatActivity {
    LinearLayout hareketlerAnaLayout;
    Okuyucu okc;
    Yazici yzc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaziciliste);
        yzc=new Yazici(YazicilisteActivity.this);
        okc=new Okuyucu(YazicilisteActivity.this);
        setTitle(getString(R.string.yzclist));
        hareketlerAnaLayout=(LinearLayout) findViewById(R.id.hareketlerAnaLinearlayout);

        ArrayList<Yazicikayit> yaziciListesi=okc.yazicileriGetir();

        LinearLayout.LayoutParams hrkHorizantalLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        hrkHorizantalLayoutParams.gravity= Gravity.CENTER_VERTICAL;

        LinearLayout.LayoutParams vievLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vievLayoutParams.setMargins(0,0,0,20);

        LinearLayout.LayoutParams vievsLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vievsLayoutParams.setMargins(0,0,0,70);

        for (int n=0;n<yaziciListesi.size();n++) {
            Yazicikayit curYazici=yaziciListesi.get(n);

            LinearLayout curyzcLayout = new LinearLayout(this);
            curyzcLayout.setOrientation(LinearLayout.VERTICAL);
            curyzcLayout.setLayoutParams(hrkHorizantalLayoutParams);
            curyzcLayout.setPadding(10, 10, 10, 10);




            TextView envnoTextView = new TextView(this);
            envnoTextView.setText(String.valueOf("Env no:                          "+curYazici.getEnvno()));
            envnoTextView.setBackground(getDrawable(R.drawable.azoval));
            envnoTextView.setTextSize(20);
            envnoTextView.setTextColor(Color.WHITE);
            envnoTextView.setLayoutParams(vievLayoutParams);

            envnoTextView.setPadding(25, 25, 25, 25);

            curyzcLayout.addView(envnoTextView);

            TextView mmTextView = new TextView(this);
            mmTextView.setText("Marka:                           "+curYazici.getMarka());
            mmTextView.setTextSize(20);
            mmTextView.setTextColor(Color.WHITE);
            mmTextView.setBackground(getDrawable(R.drawable.azoval));
            mmTextView.setPadding(25, 25, 25, 25);
            mmTextView.setLayoutParams(vievLayoutParams);
            curyzcLayout.addView(mmTextView);

            TextView mdlTextView = new TextView(this);
            mdlTextView.setText("Model:                           "+curYazici.getModel());
            mdlTextView.setTextSize(20);
            mdlTextView.setTextColor(Color.WHITE);
            mdlTextView.setLayoutParams(vievLayoutParams);
            mdlTextView.setBackground(getDrawable(R.drawable.azoval));
            mdlTextView.setPadding(25, 25, 25, 25);

            curyzcLayout.addView(mdlTextView);


            TextView ozTextView = new TextView(this);
            ozTextView.setText("Dk/Sayfa:                      "+curYazici.getDksayfa());
            ozTextView.setTextSize(20);
            ozTextView.setLayoutParams(vievLayoutParams);
            ozTextView.setTextColor(Color.WHITE);
            ozTextView.setBackground(getDrawable(R.drawable.azoval));
            ozTextView.setPadding(25, 25, 25, 25);

            curyzcLayout.addView(ozTextView);

            TextView srmTextView = new TextView(this);
            srmTextView.setText("Siyah-Beyaz/Renkli:    "+curYazici.getSbrenkli());
            srmTextView.setBackground(getDrawable(R.drawable.azoval));
            srmTextView.setLayoutParams(vievLayoutParams);
            srmTextView.setTextColor(Color.WHITE);
            srmTextView.setTextSize(20);

            srmTextView.setPadding(25, 25, 25, 25);

            curyzcLayout.addView(srmTextView);


            Button silButon = new Button(this);
            silButon.setText("Sil");
            silButon.setTextSize(20);
            silButon.setLayoutParams(vievsLayoutParams);
            silButon.setPadding(25, 25, 25, 25);
            silButon.setBackground(getDrawable(R.drawable.beyaz));
            silButon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*yzc.yzcSil(curYazici.getId());
                    hareketlerAnaLayout.invalidate();
                    Intent intt=new Intent(YazicilisteActivity.this,YazicilisteActivity.class);
                    startActivity(intt);
                    Toast.makeText(YazicilisteActivity.this, "Silme Başarılı", Toast.LENGTH_SHORT).show();*/
                    final AlertDialog.Builder builder = new AlertDialog.Builder(YazicilisteActivity.this);
                    builder.setTitle("Uyarı !!!");
                    builder.setMessage("Silmek istediğinizden Emin misiniz ?"  );
                    builder.setIcon(android.R.drawable.ic_menu_delete);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            yzc.yzcSil(curYazici.getId());
                            hareketlerAnaLayout.invalidate();
                            Intent intt=new Intent(YazicilisteActivity.this,YazicilisteActivity.class);
                            startActivity(intt);
                        }
                    });
                    builder.setNegativeButton("Hayır",null);
                    builder.show();
                }
            });

            curyzcLayout.addView(silButon);

            hareketlerAnaLayout.addView(curyzcLayout);

        }
    }
}