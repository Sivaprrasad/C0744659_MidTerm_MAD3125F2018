package com.example.sivaprrasad.electricitybillcaluculator;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorTreeAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.WeakHashMap;

public class LoginActivity extends AppCompatActivity {

    private EditText e1,e2;
    private Button log;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.lEmail);
        e2 = (EditText)findViewById(R.id.lPass);
        log = (Button)findViewById(R.id.login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean chkemailpass = db.emailpassword(email,password);
                if (chkemailpass==true){
                    Intent i = new Intent(LoginActivity.this, ElectricityBillActivity.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Successfully Logged In", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
