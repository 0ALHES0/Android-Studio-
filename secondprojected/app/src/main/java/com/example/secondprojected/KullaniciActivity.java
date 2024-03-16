package com.example.secondprojected;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secondprojected.Veritaban.Kullanıcı;
import com.example.secondprojected.Veritaban.Yazici;

public class KullaniciActivity extends AppCompatActivity {
    Button btn,btn1,btn2;
    EditText adi,soyadi,kulAdi,sifre;
    Context context=this;
    Yazici yzc;
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici);

        setTitle(getString(R.string.kcis));

        btn2 = (Button) findViewById(R.id.btn_göster);

        yzc = new Yazici(KullaniciActivity.this);
        btn = (Button) findViewById(R.id.btn_kaydet);
        adi = (EditText) findViewById(R.id.editad);
        soyadi = (EditText) findViewById(R.id.editsoyad);
        kulAdi = (EditText) findViewById(R.id.editkullanici);
        sifre = (EditText) findViewById(R.id.editsifre);
        msg =(TextView) findViewById(R.id.g);
        //Yazicikayit curYazici=yaziciListesi.get(n);
        Kullanıcı curKullanıcı=new Kullanıcı();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eno = adi.getText().toString();
                String marka = soyadi.getText().toString();
                String model = kulAdi.getText().toString();
                String dks = sifre.getText().toString();
                if(eno.length() ==0 ){

                    Toast.makeText(KullaniciActivity.this, "Ad kısmını doldurunuz", Toast.LENGTH_SHORT).show();
                }

                else if (marka.equals("")){
                    Toast.makeText(KullaniciActivity.this, "Soyad kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }

                else if (model.equals("")){
                    Toast.makeText(KullaniciActivity.this, "Kullanıcı Adı kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }
                else if (dks.equals("")){
                    Toast.makeText(KullaniciActivity.this, "Şifre kısmını doldurunuz", Toast.LENGTH_SHORT).show();

                }


                else  {
                    boolean kullaniciKaydet = yzc.kullaniciKaydet(eno,marka,model,dks);

                    Toast.makeText(KullaniciActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();

                    msg.setText("Kayıt başarılı");
                }






            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt=new Intent(KullaniciActivity.this,KullanicListeActivity.class);
                startActivity(intt);


            }
        });



    }
}