package com.example.secondprojected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secondprojected.Veritaban.Okuyucu;

public class RaporlarActivity extends AppCompatActivity {
    Button btn,btn1;
    TextView msg,csg,asg,hsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raporlar);

        setTitle(getString(R.string.rprlr));

        btn1 =(Button)findViewById(R.id.deneme);
        btn =(Button)findViewById(R.id.b);
        msg=(TextView) findViewById(R.id.c);
        csg=(TextView) findViewById(R.id.d) ;
        asg=(TextView) findViewById(R.id.e) ;
        hsg=(TextView) findViewById(R.id.f) ;

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Okuyucu okc = new Okuyucu(RaporlarActivity.this);
                TextView text=(TextView) findViewById(R.id.c);
                text.setText(String.valueOf(okc.pcleriGetir().size()));
                TextView texts=(TextView) findViewById(R.id.d);
                texts.setText(String.valueOf(okc.yazicileriGetir().size()));
                TextView texts1=(TextView) findViewById(R.id.e);
                texts1.setText(String.valueOf(okc.tarayicilariGetir().size()));
                TextView texts2=(TextView) findViewById(R.id.f);
                texts2.setText(String.valueOf(okc.tabletleriGetir().size()));
                TextView texts3=(TextView) findViewById(R.id.g);
                texts3.setText(String.valueOf(okc.kullanicilariGetir().size()));

            }
        });
    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),GrafikActivity.class));
        }
    });




    }





}