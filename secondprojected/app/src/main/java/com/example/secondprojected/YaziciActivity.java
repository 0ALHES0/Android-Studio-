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

public class YaziciActivity extends AppCompatActivity {
    Button btn;
    EditText envno1,mrk,mdl,dk,sb;
    Context context=this;
    Yazici yzc;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yazici);

        setTitle(getString(R.string.yzckyt));

        yzc=new Yazici(YaziciActivity.this);

        btn =(Button)findViewById(R.id.btn_kaydet);
        envno1=(EditText) findViewById(R.id.a);
        mrk=(EditText) findViewById(R.id.b);
        mdl=(EditText) findViewById(R.id.c);
        dk=(EditText) findViewById(R.id.d);
        sb=(EditText) findViewById(R.id.e);
        msg=(TextView) findViewById(R.id.g);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* if(yzc.yaziciKaydet(Integer.parseInt(envno1.getText().toString()),mrk.getText().toString(),mdl.getText().toString(),dk.getText().toString(),sb.getText().toString())){
                    msg.setText("Kayıt başarılı");
                    Toast.makeText(YaziciActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                }
                else{

                }
*/
                String eno = envno1.getText().toString();
                String marka = mrk.getText().toString();
                String model = mdl.getText().toString();
                String dks = dk.getText().toString();
                String sbs = sb.getText().toString();
                if(eno.length() ==0 ){

                    Toast.makeText(YaziciActivity.this, "Envanter Numarasını giriniz", Toast.LENGTH_SHORT).show();
                }

                else if (marka.equals("")){
                    Toast.makeText(YaziciActivity.this, "Marka kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }

                else if (model.equals("")){
                    Toast.makeText(YaziciActivity.this, "Model kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else if (dks.equals("")){
                    Toast.makeText(YaziciActivity.this, "DK/Sayfa kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else if (sbs.equals("")){
                    Toast.makeText(YaziciActivity.this, "Siyah/Beyaz-Renkli kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }

                else  {
                    boolean yaziciKaydet = yzc.yaziciKaydet(Integer.parseInt (eno),marka,model,dks,sbs);

                    Toast.makeText(YaziciActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();

                    msg.setText("Kayıt başarılı");
                }



            }
        });

    }
}