package com.example.shareprefrencetask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textName,textDept,textEmail,textPassword;
EditText etName,etDept,etEmail,etPassword;
Button SaveBtn,LoadBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName=findViewById(R.id.tvOne);
        textDept=findViewById(R.id.tvTwo);
        textEmail=findViewById(R.id.tvThree);
        textPassword=findViewById(R.id.tvFour);
        etName=findViewById(R.id.etOne);
        etDept=findViewById(R.id.ettwo);
        etEmail=findViewById(R.id.etthree);
        etPassword=findViewById(R.id.etfour);
        SaveBtn=findViewById(R.id.btnSave);
        LoadBtn=findViewById(R.id.btnLoad);
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           SaveData();
            }
        });
LoadBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
     LoadData();
    }
});
    }
    private void LoadData(){
        String text1="",text2 = "",text3="",text4="";
        SharedPreferences sharedPreferences=getSharedPreferences("shared",MODE_PRIVATE);
       text1=sharedPreferences.getString("keyName","");
       text2=sharedPreferences.getString("keyDept","");
       text3=sharedPreferences.getString("keyEmail","");
       text4=sharedPreferences.getString("keyPassword","");
       textName.setText(text1);
       textDept.setText(text2);
       textEmail.setText(text3);
       textPassword.setText(text4);
    }
    private void  SaveData(){
        String Name=etName.getText().toString();
        String Dept=etDept.getText().toString();
        String Email=etEmail.getText().toString();
        String Password=etPassword.getText().toString();
        SharedPreferences sharedPreferences=getSharedPreferences("shared",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("keyName",Name);
        editor.putString("keyDept",Dept);
        editor.putString("keyEmail",Email);
        editor.putString("keyPassword",Password);
        editor.apply();
        Toast.makeText(this, "Save Data", Toast.LENGTH_SHORT).show();

    }
}