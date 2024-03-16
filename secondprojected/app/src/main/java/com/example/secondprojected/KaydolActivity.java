package com.example.secondprojected;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secondprojected.Veritaban.DBHelper;

public class KaydolActivity extends AppCompatActivity {
    EditText username, password, repassword;
    Button signup;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        setTitle(getString(R.string.kydl));
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(KaydolActivity.this, "Lütfen tüm alanları girin", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(KaydolActivity.this, "Kaydolma Başarılı", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(KaydolActivity.this, "Kaydolma Başarılı", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(KaydolActivity.this, "Kullanıcı Adı Kayıtlı Tekrar Deneyin ", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(KaydolActivity.this, "Parola eşleşmiyor", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

       /* final  Button titresim =findViewById(R.id.titresim);

        Vibrator vibrator =(Vibrator) getSystemService(VIBRATOR_SERVICE);

        final long [] pattern ={2000,1000};

        titresim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titresim.getText().toString().equals("Start")){
                    final long [] pattern ={2000,1000};
                    vibrator.vibrate(pattern,-1);

                    Toast.makeText(KaydolActivity.this,"Started",Toast.LENGTH_SHORT).show();
                    titresim.setText("Stop");
                }else{
                    vibrator.cancel();
                    titresim.setText("Start");
                    Toast.makeText(KaydolActivity.this,"Cancelled",Toast.LENGTH_SHORT).show();
                }
            }
        });*/



    }
}





