package com.example.cryptoj;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button get_xlm,get_xrp,get_trx,get_zil;
    EditText data_in;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_xlm=findViewById(R.id.get_xlm);
        get_trx=findViewById(R.id.get_trx);
        get_xrp=findViewById(R.id.get_xrp);
        get_zil=findViewById(R.id.get_zil);
        data_in=findViewById(R.id.data_in);



        get_xlm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(data_in.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter an amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent = new Intent(MainActivity.this, payment.class);
                    intent.putExtra("xlm", data_in.getText().toString());
                    startActivity(intent);
                }
            }
        });


        get_xrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(data_in.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter an amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent = new Intent(MainActivity.this, xrp_payment.class);
                    intent.putExtra("xrp", data_in.getText().toString());
                    startActivity(intent);
                }
            }
        });

        get_trx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(data_in.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter an amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent = new Intent(MainActivity.this, tron_payment.class);
                    intent.putExtra("tron", data_in.getText().toString());
                    startActivity(intent);
                }
            }
        });

        get_zil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(data_in.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Please enter an amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent = new Intent(MainActivity.this, zln_payment.class);
                    intent.putExtra("zln", data_in.getText().toString());
                    startActivity(intent);
                }
            }
        });


        }



}