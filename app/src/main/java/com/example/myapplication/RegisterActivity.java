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
    Login_RegisterDBHelper DB;

    //Global Variable for Membership
    String membership_type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Activity first call or launched - method is responsible to create the activity.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initializing variables i.e. creating and defining variables for TextViews, Image_View and RadioButtons
        username =(TextView) findViewById(R.id.username);
        password =(TextView) findViewById(R.id.password);
        email =(TextView) findViewById(R.id.email);
        registerbtn = (MaterialButton) findViewById(R.id.registerbtn);
        ckpm = (ImageView) findViewById(R.id.ckpm);

        radioStandard = (RadioButton) findViewById(R.id.radioStandard);
        radioSilver = (RadioButton) findViewById(R.id.radioSilver);
        radioGold = (RadioButton) findViewById(R.id.radioGold);
        radioGroup = (RadioGroup) findViewById(R.id.RGroup);


        // Creating a new DBHandler class and passing our context to it.
        DB = new Login_RegisterDBHelper(RegisterActivity.this);

        // Pressing REGISTER button will bring user to payment page
        registerbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String mail = email.getText().toString();


                if(user.equals("") || pass.equals("") || mail.equals(""))
                    Toast.makeText(RegisterActivity.this,"All Fields are Required", Toast.LENGTH_SHORT).show();

                else {

                    Boolean insert = DB.inputData(user,pass,mail,membership_type); // Provoking our InsertData function in our DBHelper class passing through user input

                    if(insert == false) {
                        Toast.makeText(RegisterActivity.this,"Register Failed!",Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(RegisterActivity.this,"Register Successful!",Toast.LENGTH_SHORT).show(); // Displaying message to user if they registered correctly
                    openPaymentActivity(); // Open up paymentActivity once they completed the Registration Form


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

        boolean checked = ((RadioButton) view).isChecked(); // creating checked variable to see if the user has clicked on a radiobutton

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioStandard: // User clicks on the Standard Customer Type
                if (checked)
                    membership_type = "Standard";
                    Toast.makeText(this,"Selected Radio Button:", Toast.LENGTH_SHORT).show(); // Displaying message to user after they selected on the Radio Button
                break;
            case R.id.radioSilver: // User clicks on the Sliver Customer Type
                if (checked)
                    membership_type = "Sliver";
                    Toast.makeText(this,"Selected Radio Button:", Toast.LENGTH_SHORT).show(); // Displaying message to user after they selected on the Radio Button
                break;
            case R.id.radioGold: // User clicks on the Gold Customer Type
                if (checked)
                    membership_type = "Gold";
                    Toast.makeText(this,"Selected Radio Button:", Toast.LENGTH_SHORT).show(); // Displaying message to user after they selected on the Radio Button
                break;
        }
    }

}

//test-comment for fix will be removed later