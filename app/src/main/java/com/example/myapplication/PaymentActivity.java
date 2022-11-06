package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {
    EditText nameEnter, cvcEnter, expiryDateEnter, cardNumberEnter;
    TextView payHere, cardNumber, expiryDate, cvc, name;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        nameEnter =(EditText) findViewById(R.id.nameEnter);
        cvcEnter =(EditText) findViewById(R.id.cvcEnter);
        expiryDateEnter =(EditText) findViewById(R.id.expiryDateEnter);
        cardNumberEnter =(EditText) findViewById(R.id.cardNumberEnter);
        payHere =(TextView) findViewById(R.id.payHere);
        cardNumber =(TextView) findViewById(R.id.cardNumber);
        expiryDate =(TextView) findViewById(R.id.expiryDate);
        cvc =(TextView) findViewById(R.id.cvc);
        name =(TextView) findViewById(R.id.name);
        pay =(Button) findViewById(R.id.pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this,"Payment Successful!",Toast.LENGTH_SHORT).show();
                openLoginActivity();
            }
        });
    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}