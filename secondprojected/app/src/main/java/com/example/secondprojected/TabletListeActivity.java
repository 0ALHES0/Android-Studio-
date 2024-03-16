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
import com.example.secondprojected.Veritaban.Tablet;
import com.example.secondprojected.Veritaban.Yazici;

import java.util.ArrayList;

public class TabletListeActivity extends AppCompatActivity {
    LinearLayout hareketlerAnaLayout;
    Okuyucu okc;
    Yazici yzc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet_liste);
        yzc=new Yazici(TabletListeActivity.this);
        okc=new Okuyucu(TabletListeActivity.this);
        setTitle(getString(R.string.tbltlist));
        hareketlerAnaLayout=(LinearLayout) findViewById(R.id.hareketlerAnaLinearlayout);

        ArrayList<Tablet> tabletList=okc.tabletleriGetir();

        LinearLayout.LayoutParams hrkHorizantalLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        hrkHorizantalLayoutParams.gravity= Gravity.CENTER_VERTICAL;


        LinearLayout.LayoutParams vievLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vievLayoutParams.setMargins(0,0,0,20);

        LinearLayout.LayoutParams vievsLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vievsLayoutParams.setMargins(0,0,0,70);

        for (int n=0;n<tabletList.size();n++) {
            Tablet curTablet=tabletList.get(n);

            LinearLayout curyzcLayout = new LinearLayout(this);
            curyzcLayout.setOrientation(LinearLayout.VERTICAL);
            curyzcLayout.setLayoutParams(hrkHorizantalLayoutParams);
            curyzcLayout.setPadding(10, 10, 10, 10);




            TextView envnoTextView = new TextView(this);
            envnoTextView.setText(String.valueOf("Env no:              "+curTablet.getEnvno()));
            envnoTextView.setTextSize(20);
            envnoTextView.setBackground(getDrawable(R.drawable.azoval));
            envnoTextView.setTextColor(Color.WHITE);
            envnoTextView.setLayoutParams(vievLayoutParams);
            envnoTextView.setPadding(25, 25, 25, 25);

            curyzcLayout.addView(envnoTextView);

            TextView mmTextView = new TextView(this);
            mmTextView.setText("Marka:               "+curTablet.getMarka());
            mmTextView.setTextSize(20);
            mmTextView.setTextColor(Color.WHITE);
            mmTextView.setLayoutParams(vievLayoutParams);
            mmTextView.setBackground(getDrawable(R.drawable.azoval));
            mmTextView.setPadding(25, 25, 25, 25);

            curyzcLayout.addView(mmTextView);

            TextView mdlTextView = new TextView(this);
            mdlTextView.setText("Model:               "+curTablet.getModel());
            mdlTextView.setTextSize(20);
            mdlTextView.setTextColor(Color.WHITE);
            mdlTextView.setLayoutParams(vievLayoutParams);
            mdlTextView.setBackground(getDrawable(R.drawable.azoval));
            mdlTextView.setPadding(25, 25, 25, 25);

            curyzcLayout.addView(mdlTextView);


            TextView ozTextView = new TextView(this);
            ozTextView.setText("Ekran Boyutu:   "+curTablet.getEkrbyt());
            ozTextView.setTextSize(20);
            ozTextView.setTextColor(Color.WHITE);
            ozTextView.setLayoutParams(vievLayoutParams);
            ozTextView.setBackground(getDrawable(R.drawable.azoval));
            ozTextView.setPadding(25, 25, 25, 25);

            curyzcLayout.addView(ozTextView);

            TextView srmTextView = new TextView(this);
            srmTextView.setText("Sürüm:               "+curTablet.getSrm());
            srmTextView.setTextSize(20);
            srmTextView.setTextColor(Color.WHITE);
            srmTextView.setLayoutParams(vievLayoutParams);
            srmTextView.setBackground(getDrawable(R.drawable.azoval));
            srmTextView.setPadding(25, 25, 25, 25);

            curyzcLayout.addView(srmTextView);


            Button silButon = new Button(this);
            silButon.setText("Sil");
            silButon.setBackground(getDrawable(R.drawable.beyaz));
            silButon.setTextSize(20);
            silButon.setPadding(25, 25, 25, 25);
            silButon.setLayoutParams(vievsLayoutParams);

            silButon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*yzc.tbltSil(curTablet.getId());
                    hareketlerAnaLayout.invalidate();
                    Intent intt=new Intent(TabletListeActivity.this,TabletListeActivity.class);
                    startActivity(intt);
                    Toast.makeText(TabletListeActivity.this, "Silme Başarılı", Toast.LENGTH_SHORT).show();*/
                    final AlertDialog.Builder builder = new AlertDialog.Builder(TabletListeActivity.this);
                    builder.setTitle("Uyarı !!!");
                    builder.setMessage("Silmek istediğinizden Emin misiniz ?"  );
                    builder.setIcon(android.R.drawable.ic_menu_delete);
                    builder.setCancelable(false);
                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            yzc.tbltSil(curTablet.getId());
                            hareketlerAnaLayout.invalidate();
                            Intent intt=new Intent(TabletListeActivity.this,TabletListeActivity.class);
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