package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {
    // Variables declared
    MaterialButton registerbtn;
    TextView username, password, email;
    RadioButton radioStandard, radioSilver, radioGold;
    ImageView ckpm;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initializing variables
        username =(TextView) findViewById(R.id.username);
        password =(TextView) findViewById(R.id.password);
        email =(TextView) findViewById(R.id.email);
        registerbtn = (MaterialButton) findViewById(R.id.registerbtn);
        ckpm = (ImageView) findViewById(R.id.ckpm);
        radioStandard = (RadioButton) findViewById(R.id.radioStandard);
        radioSilver = (RadioButton) findViewById(R.id.radioSilver);
        radioGold = (RadioButton) findViewById(R.id.radioGold);

        // Pressing REGISTER button will bring user to payment page
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checking username and password
                // Will check for user in database later
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin") && email.getText().toString().equals("admin@ckpm.com")){
                    // Switching to register page by calling open activity method
                    openPaymentActivity();
                } else
                    i = 1;
            }
        });
    }

    // this class will open the new register activity which holds the register form
    public void openPaymentActivity() {
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }
}