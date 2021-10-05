package com.example.cryptoj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class xrp_payment extends AppCompatActivity {

    Intent intent;
    TextView link, value;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrp_payment);
        value = findViewById(R.id.currencyRateView2);
        progressBar = findViewById(R.id.progressBar2);
        link = findViewById(R.id.link2);
        link.setText("Converted Crypto Value:");
        Linkify.addLinks(link, Linkify.WEB_URLS);
        intent = getIntent();
        String data_in = intent.getStringExtra("xrp");



        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        progressBar.setVisibility(View.VISIBLE);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=XRP&to_currency=INR&apikey=ZEOHYLMZ8WIMTUAJ&fbclid=IwAR2SfCHSFawvR-jLQyphgI2hmX4Ts6fRu19M7vm_y_upsF6k-IjV3ZM8LQE", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject object = response.getJSONObject("Realtime Currency Exchange Rate");
                    String getVal = object.getString("5. Exchange Rate");
                    Double finalValue = Double.parseDouble(data_in) / Double.parseDouble(getVal);

                    progressBar.setVisibility(View.INVISIBLE);
                    value.setText(finalValue + "");




                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.d("myapp", "Something went wrong");
            }
        });

        requestQueue.add(jsonObjectRequest);


    }
}