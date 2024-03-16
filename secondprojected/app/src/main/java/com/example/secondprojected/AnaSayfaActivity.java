package com.example.secondprojected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AnaSayfaActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
   // TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);

        setTitle(getString(R.string.anasayfa));

        //Bundle parametreler=getIntent().getExtras();
        //tt=(TextView) findViewById(R.id.ana);
       // String gelentext =parametreler.getString("name");
        //tt.setText(gelentext);




        btn1 =(Button)findViewById(R.id.first);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(AnaSayfaActivity.this, EnvKayitActivity.class);
                startActivity(intt);
            }
        });

        btn2 =(Button)findViewById(R.id.second);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(AnaSayfaActivity.this, RaporlarbutonActivity.class);
                startActivity(intt);
            }
        });
        btn3 =(Button)findViewById(R.id.thirty);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(AnaSayfaActivity.this, KullaniciActivity.class);
                startActivity(intt);
            }
        });



    }
}