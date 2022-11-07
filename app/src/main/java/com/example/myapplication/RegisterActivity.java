package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {
    // Variables declared
    MaterialButton registerbtn;
    TextView username, password, email;
    RadioButton radioStandard, radioSilver, radioGold;
    ImageView ckpm;
    RadioGroup radioGroup;
    int i;
    Login_RegisterDBHelper DB;


    //Global Variable for Membership
    String membership_type = "";


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
        radioGroup = (RadioGroup) findViewById(R.id.RGroup);

        DB = new Login_RegisterDBHelper(RegisterActivity.this);

        // Pressing REGISTER button will bring user to payment page

        registerbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String mail = email.getText().toString();


                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(mail))
                    Toast.makeText(RegisterActivity.this,"All Fields are Required", Toast.LENGTH_SHORT).show();


                // Checking username and password
                // Will check for user in database later

                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin") && email.getText().toString().equals("admin@ckpm.com")){
                    // Switching to register page by calling open activity method
                    openPaymentActivity();
                }

                else {

                    Boolean insert = DB.inputData(user,pass,mail,membership_type);

                    if(insert == true) {
                        Toast.makeText(RegisterActivity.this,"Register Successful!",Toast.LENGTH_SHORT).show();
                        openPaymentActivity();
                    }
                    else {
                        Toast.makeText(RegisterActivity.this,"Register Failed!",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }

    // this class will open the new register activity which holds the register form
    public void openPaymentActivity() {
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }


    public void onRadioButtonClicked(View view) {


        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioStandard:
                if (checked)
                    Toast.makeText(this,"Selected Radio Button:", Toast.LENGTH_SHORT).show();
                    membership_type = "Standard";
                    i++;
                    break;
            case R.id.radioSilver:
                if (checked)
                    Toast.makeText(this,"Selected Radio Button:", Toast.LENGTH_SHORT).show();
                    membership_type = "Sliver";
                    i++;
                    break;
            case R.id.radioGold:
                if (checked)
                    Toast.makeText(this,"Selected Radio Button:", Toast.LENGTH_SHORT).show();
                    membership_type = "Gold";
                    i++;
                    break;
        }
    }

}