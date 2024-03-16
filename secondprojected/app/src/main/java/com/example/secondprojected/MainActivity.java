package com.example.secondprojected;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secondprojected.Veritaban.DBHelper;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn1;
    EditText user,pass;
    Context context=this;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Drawable ff=getDrawable(R.drawable.basliksekli);
       // ActionBar fgf =this.getActionBar();
        //fgf.setBackgroundDrawable(ff);
        setTitle(getString(R.string.Giris));

        //TabanHelper hp=new TabanHelper(MainActivity.this);

        DB =new DBHelper(MainActivity.this);
        user=(EditText) findViewById(R.id.bir);
        pass=(EditText) findViewById(R.id.iki);
        btn =(Button)findViewById(R.id.tiklabutton);
        btn1 =(Button)findViewById(R.id.tiklabutton1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userke = user.getText().toString();
                String passke = pass.getText().toString();

                if(userke.equals("")||passke.equals(""))
                    Toast.makeText(MainActivity.this, "Lütfen tüm alanları girin", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(userke, passke);
                    if(checkuserpass==true){
                        Intent intt=new Intent(MainActivity.this,AnaSayfaActivity.class);
                        startActivity(intt);



                    }else{
                        Toast.makeText(MainActivity.this, "Geçersiz kimlik bilgileri", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn1.setOnClickListener((new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intt=new Intent(MainActivity.this,KaydolActivity.class);
                 startActivity(intt);


    }
}));



    }

}