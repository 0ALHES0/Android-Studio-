package com.example.secondprojected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EnvKayitActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_env_kayit);

        setTitle(getString(R.string.Envkyt));

        btn =(Button)findViewById(R.id.first);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(EnvKayitActivity.this, PcKayitActivity.class);
                startActivity(intt);
            }
        });
        btn =(Button)findViewById(R.id.second);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(EnvKayitActivity.this, YaziciActivity.class);
                startActivity(intt);
            }
        });
        btn =(Button)findViewById(R.id.thirty);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(EnvKayitActivity.this, TarayiciActivity.class);
                startActivity(intt);
            }
        });
        btn =(Button)findViewById(R.id.four);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(EnvKayitActivity.this, TabletActivity.class);
                startActivity(intt);
            }
        });



    }
}