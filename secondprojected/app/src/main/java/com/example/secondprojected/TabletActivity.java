package com.example.secondprojected;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secondprojected.Veritaban.Yazici;

public class TabletActivity extends AppCompatActivity {
    Button btn;
    EditText envno1,mrk,mdl,ekrnbyt,srm;
    Context context=this;
    Yazici yzc;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet);

        setTitle(getString(R.string.tbltkyt));

        yzc =new Yazici(TabletActivity.this);
        btn = (Button) findViewById(R.id.btn_kaydet);
        envno1 = (EditText) findViewById(R.id.a);
        mrk = (EditText) findViewById(R.id.b);
        mdl = (EditText) findViewById(R.id.c);
        ekrnbyt = (EditText) findViewById(R.id.d);
        srm = (EditText) findViewById(R.id.f);
        msg = (TextView) findViewById(R.id.g);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eno = envno1.getText().toString();
                String marka = mrk.getText().toString();
                String model = mdl.getText().toString();
                String ekranboyut = ekrnbyt.getText().toString();
                String surum = srm.getText().toString();

                if(eno.length() ==0 ){

                    Toast.makeText(TabletActivity.this, "Envanter Numarasını giriniz", Toast.LENGTH_SHORT).show();
                }

                else if (marka.equals("")){
                    Toast.makeText(TabletActivity.this, "Marka kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }

                else if (model.equals("")){
                    Toast.makeText(TabletActivity.this, "Model kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else if (ekranboyut.equals("")){
                    Toast.makeText(TabletActivity.this, "Ekran boyut kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else if (surum.equals("")){
                    Toast.makeText(TabletActivity.this, "Android sürüm kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }

                else  {
                    boolean tabletKaydet = yzc.tabletKaydet(Integer.parseInt (eno),marka,model,ekranboyut,surum);

                    Toast.makeText(TabletActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();

                    msg.setText("Kayıt başarılı");
                }

                //yzc.tabletKaydet(Integer.parseInt(envno1.getText().toString()),mrk.getText().toString(),mdl.getText().toString(),ekrnbyt.getText().toString(),srm.getText().toString()))
            }
        });





    }
}