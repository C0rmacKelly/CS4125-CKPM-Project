package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewCustomerInfo extends AppCompatActivity {

    private ArrayList<UserDTO> userDTOArrayList;
    private Login_RegisterDBHelper dbHelper;
    private UserViewAdapter userViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer_info);

        // initialising all variables.
        userDTOArrayList = new ArrayList<>();
        dbHelper = new Login_RegisterDBHelper(ViewCustomerInfo.this);

        // getting the movie array list from db handler class.
        userDTOArrayList = dbHelper.readUsers();

        // Passing the array list to the adapter class.
        userViewAdapter = new UserViewAdapter(userDTOArrayList);
        recyclerView = findViewById(R.id.idCustomersInfo);

        // setting layout manager for the recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCustomerInfo.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // setting adapter to recycler view.
        recyclerView.setAdapter(userViewAdapter);


    }
}