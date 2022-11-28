package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SubscriptionView extends AppCompatActivity {

    TextView MembershipMessage;
    Button StandardMembership;
    Button SliverMembership;
    Button GoldMemberShip;
    Login_RegisterDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_subscriptions);

        MembershipMessage = (TextView) findViewById(R.id.idSubscriptionNotice);
        StandardMembership =(Button) findViewById(R.id.idStandardMember);
        SliverMembership = (Button) findViewById(R.id.idSliverMember);
        GoldMemberShip = (Button) findViewById(R.id.idGoldMember);

        DB = new Login_RegisterDBHelper(SubscriptionView.this);


    }
}


