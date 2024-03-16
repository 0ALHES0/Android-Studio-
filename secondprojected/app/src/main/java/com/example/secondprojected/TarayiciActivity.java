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

public class TarayiciActivity extends AppCompatActivity {
    Button btn;
    EditText envno1,mrk,mdl,dk,max;
    Context context=this;
    Yazici yzc;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarayici);

        setTitle(getString(R.string.tryckyt));


        yzc=new Yazici(TarayiciActivity.this);


        btn =(Button)findViewById(R.id.btn_kaydet);
        envno1=(EditText) findViewById(R.id.a);
        mrk=(EditText) findViewById(R.id.b);
        mdl=(EditText) findViewById(R.id.c);
        dk=(EditText) findViewById(R.id.d);
        max=(EditText) findViewById(R.id.e);
        msg=(TextView) findViewById(R.id.f);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eno = envno1.getText().toString();
                String marka = mrk.getText().toString();
                String model = mdl.getText().toString();
                String dks = dk.getText().toString();
                String maxx = max.getText().toString();
                if(eno.length() ==0 ){

                    Toast.makeText(TarayiciActivity.this, "Envanter Numarasını giriniz", Toast.LENGTH_SHORT).show();
                }

                else if (marka.equals("")){
                    Toast.makeText(TarayiciActivity.this, "Marka kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }

                else if (model.equals("")){
                    Toast.makeText(TarayiciActivity.this, "Model kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else if (dks.equals("")){
                    Toast.makeText(TarayiciActivity.this, "Dk/Sayfa kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else if (maxx.equals("")){
                    Toast.makeText(TarayiciActivity.this, "Max.Çözünürlük kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }

                else  {
                    boolean tarayiciKaydet = yzc.tarayiciKaydet(Integer.parseInt (eno),marka,model,dks,maxx);

                    Toast.makeText(TarayiciActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();

                    msg.setText("Kayıt başarılı");
                }
            }
        });

    }
}