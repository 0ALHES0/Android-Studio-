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

public class PcKayitActivity extends AppCompatActivity {
    Button btn;
    EditText envno1,mrk,mdl,isl,ram,hdd;
    Context context=this;
    Yazici yzc;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_kayit);

        setTitle(getString(R.string.pckyıt));

        yzc=new Yazici(PcKayitActivity.this);

        btn =(Button)findViewById(R.id.btn_kaydet);
        envno1=(EditText) findViewById(R.id.a);
        mrk=(EditText) findViewById(R.id.b);
        mdl=(EditText) findViewById(R.id.c);
        isl=(EditText) findViewById(R.id.d);
        ram=(EditText) findViewById(R.id.e);
        hdd=(EditText) findViewById(R.id.f);
        msg=(TextView) findViewById(R.id.g);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eno = envno1.getText().toString();
                String marka = mrk.getText().toString();
                String model = mdl.getText().toString();
                String islemci = isl.getText().toString();
                String ramm = ram.getText().toString();
                String hddd = hdd.getText().toString();
                if(eno.length() ==0 ){

                    Toast.makeText(PcKayitActivity.this, "Envanter Numarasını giriniz", Toast.LENGTH_SHORT).show();
                }

                else if (marka.equals("")){
                    Toast.makeText(PcKayitActivity.this, "Marka kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }

                else if (model.equals("")){
                    Toast.makeText(PcKayitActivity.this, "Model kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else if (islemci.equals("")){
                    Toast.makeText(PcKayitActivity.this, "İşlemci kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else if (ramm.equals("")){
                    Toast.makeText(PcKayitActivity.this, "Ram kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else if (hddd.equals("")){
                    Toast.makeText(PcKayitActivity.this, "HDD kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else  {
                    boolean bilgisayarKaydet = yzc.bilgisayarKaydet(Integer.parseInt (eno),marka,model,islemci,ramm,hddd);

                    Toast.makeText(PcKayitActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();

                    msg.setText("Kayıt başarılı");
                }

            }
        });


    }
}