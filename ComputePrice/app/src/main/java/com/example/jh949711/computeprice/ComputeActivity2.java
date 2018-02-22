package com.example.jh949711.computeprice;
/*
This is the class that handles after we click compute.
This one will have the add and the list buttons active.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ComputeActivity2 extends AppCompatActivity {

    String name, price, quantity, tax, totalPrice;
    Button compute, add, list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
        Bundle extras = getIntent().getExtras();
        name = extras.getString("name");
        price = extras.getString("price");
        quantity = extras.getString("quantity");
        tax = extras.getString("tax");
        totalPrice = extras.getString("totalPrice");



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addScreen = new Intent(ComputeActivity2.this,AddActivity.class);
                startActivity(new Intent(ComputeActivity2.this, AddActivity.class));

            }
        });
    }
}