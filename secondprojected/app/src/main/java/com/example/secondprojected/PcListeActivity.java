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

import com.example.secondprojected.Veritaban.Bilgisayar;
import com.example.secondprojected.Veritaban.Okuyucu;
import com.example.secondprojected.Veritaban.Yazici;

import java.util.ArrayList;

public class PcListeActivity extends AppCompatActivity {
    LinearLayout hareketlerAnaLayout;
    Okuyucu okc;
    Yazici yzc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_liste);
        setTitle(getString(R.string.pclist));
        yzc=new Yazici(PcListeActivity.this);
        okc=new Okuyucu(PcListeActivity.this);
        hareketlerAnaLayout=(LinearLayout) findViewById(R.id.hareketlerAnaLinearlayout);
        ArrayList<Bilgisayar> bilgisayarListesi=okc.pcleriGetir();
        LinearLayout.LayoutParams hrkHorizantalLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        hrkHorizantalLayoutParams.gravity= Gravity.CENTER_VERTICAL;
        LinearLayout.LayoutParams vievLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vievLayoutParams.setMargins(0,0,0,20);
        LinearLayout.LayoutParams vievsLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vievsLayoutParams.setMargins(0,0,0,70);
        for (int n=0;n<bilgisayarListesi.size();n++) {
            Bilgisayar curBilgisayar=bilgisayarListesi.get(n);

                LinearLayout curPcLayout = new LinearLayout(this);
                curPcLayout.setOrientation(LinearLayout.VERTICAL);
                curPcLayout.setLayoutParams(hrkHorizantalLayoutParams);
                curPcLayout.setPadding(10, 10, 10, 10);

                TextView envnoTextView = new TextView(this);
                envnoTextView.setText(String.valueOf("Env no:       "+curBilgisayar.getEnvno()));
                envnoTextView.setTextSize(20);
                envnoTextView.setTextColor(Color.WHITE);
                envnoTextView.setBackground(getDrawable(R.drawable.azoval));
                envnoTextView.setPadding(25, 25, 25, 25);
                envnoTextView.setLayoutParams(vievLayoutParams);
                curPcLayout.addView(envnoTextView);

            TextView mmTextView = new TextView(this);
            mmTextView.setText("Marka:        "+curBilgisayar.getMarka());
            mmTextView.setBackground(getDrawable(R.drawable.azoval));
            mmTextView.setTextSize(20);
            mmTextView.setTextColor(Color.WHITE);
            mmTextView.setLayoutParams(vievLayoutParams);
            mmTextView.setPadding(25, 25, 25, 25);

            curPcLayout.addView(mmTextView);

            TextView mdlTextView = new TextView(this);
            mdlTextView.setText("Model:        "+curBilgisayar.getModel());
            mdlTextView.setBackground(getDrawable(R.drawable.azoval));
            mdlTextView.setTextSize(20);
            mdlTextView.setTextColor(Color.WHITE);
            mdlTextView.setLayoutParams(vievLayoutParams);
            mdlTextView.setPadding(25, 25, 25, 25);

            curPcLayout.addView(mdlTextView);

            TextView ozTextView = new TextView(this);
            ozTextView.setText("İşlemci:      "+curBilgisayar.getIslemci());
            ozTextView.setBackground(getDrawable(R.drawable.azoval));
            ozTextView.setTextSize(20);
            ozTextView.setTextColor(Color.WHITE);
            ozTextView.setLayoutParams(vievLayoutParams);
            ozTextView.setPadding(25, 25, 25, 25);

            curPcLayout.addView(ozTextView);

            TextView srmTextView = new TextView(this);
            srmTextView.setText("Ram:           "+curBilgisayar.getRam());
            srmTextView.setBackground(getDrawable(R.drawable.azoval));
            srmTextView.setTextSize(20);
            srmTextView.setTextColor(Color.WHITE);
            srmTextView.setLayoutParams(vievLayoutParams);
            srmTextView.setPadding(25, 25, 25, 25);

            curPcLayout.addView(srmTextView);

            TextView rmTextView = new TextView(this);
            rmTextView.setText("HDD:           "+curBilgisayar.getHdd());
            rmTextView.setBackground(getDrawable(R.drawable.azoval));
            rmTextView.setTextSize(20);
            rmTextView.setTextColor(Color.WHITE);
            rmTextView.setLayoutParams(vievLayoutParams);
            rmTextView.setPadding(25, 25, 25, 25);

            curPcLayout.addView(rmTextView);


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
                        final AlertDialog.Builder builder = new AlertDialog.Builder(PcListeActivity.this);
                        builder.setTitle("Uyarı !!!");
                        builder.setMessage("Silmek istediğinizden Emin misiniz ?"  );
                        builder.setIcon(android.R.drawable.ic_menu_delete);
                        builder.setCancelable(false);
                        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                yzc.pcSil(curBilgisayar.getId());
                                hareketlerAnaLayout.invalidate();
                                Intent intt=new Intent(PcListeActivity.this,PcListeActivity.class);
                                startActivity(intt);
                            }
                        });
                        builder.setNegativeButton("Hayır",null);
                        builder.show();
                    }
                });

                curPcLayout.addView(silButon);

                hareketlerAnaLayout.addView(curPcLayout);

        }
    }
}