package com.example.secondprojected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RaporlarbutonActivity extends AppCompatActivity {

    Button btns,btn,btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raporlarbuton);

        setTitle(getString(R.string.rprl));

        Button btn = (Button) findViewById(R.id.pc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intt=new Intent(RaporlarbutonActivity.this, PcListeActivity.class);
                startActivity(intt);
            }
        });

        Button btns = (Button) findViewById(R.id.rprlr);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(RaporlarbutonActivity.this, RaporlarActivity.class);
                startActivity(intt);
            }
        });

        Button btn1=(Button) findViewById(R.id.yzc);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt=new Intent(RaporlarbutonActivity.this, YazicilisteActivity.class);
                startActivity(intt);
            }
        });
        Button btn2=(Button) findViewById(R.id.tryc);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt=new Intent(RaporlarbutonActivity.this, TrycListeActivity.class);
                startActivity(intt);
            }
        });
        Button btn3=(Button) findViewById(R.id.tblt);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt=new Intent(RaporlarbutonActivity.this, TabletListeActivity.class);
                startActivity(intt);
            }
        });





    }

}



