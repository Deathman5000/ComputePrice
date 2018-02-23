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

import java.util.ArrayList;

public class ComputeActivity2 extends AppCompatActivity {

    EditText n, tp, pr, q, t;
    String name, price, quantity, tax, totalPrice, Name, Price, Quanitity;
    Button add, list;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        //if (getIntent().getExtras().getString("from").equals("ComputeActivity")) {
            Bundle extras = getIntent().getExtras();
            name = extras.getString("name");
            price = extras.getString("price");
            quantity = extras.getString("quantity");
            tax = extras.getString("tax");
            totalPrice = extras.getString("totalPrice");
        //}

        //else if (getIntent().getExtras().getString("from").equals("AddActivity")) {
            Bundle extras2 = getIntent().getExtras();
            Name = extras2.getString("Name");
            Price = extras2.getString("Price");
            Quanitity = extras2.getString("Quantity");
        //}

        n = findViewById(R.id.name);
        pr = findViewById(R.id.price);
        q = findViewById(R.id.quantity);
        t = findViewById(R.id.tax);
        tp = findViewById(R.id.totalPrice);
        add = findViewById(R.id.addButton);
        list = findViewById(R.id.listButton);


        double priceNum = Double.parseDouble(price);
        double result = Double.parseDouble(totalPrice);
        double quantityNum = Double.parseDouble(quantity);
        double taxNum = Double.parseDouble(tax);

        n.setText(name);
        tp.setText(String.format("$%,.2f", result));
        pr.setText(String.format("$%,.2f", priceNum));
        q.setText(String.format("%.0f", quantityNum));
        t.setText(String.format("%5.2f", taxNum));



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addScreen = new Intent(ComputeActivity2.this,AddActivity.class);
                count++;
                addScreen.putExtra("count",count);
                startActivity(addScreen);

            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> nameArray = new ArrayList<String>();
                ArrayList<String> priceArray = new ArrayList<String>();
                ArrayList<String> quantityArray = new ArrayList<String>();
                nameArray.add(name);
                //nameArray.add(Name);
                priceArray.add(price);
                //priceArray.add(Price);
                quantityArray.add(quantity);
                //quantityArray.add(Quanitity);
                Bundle b = new Bundle();
                b.putStringArrayList("nameArray",nameArray);
                b.putStringArrayList("priceArray",priceArray);
                b.putStringArrayList("quantityArray",quantityArray);
                Intent listScreen = new Intent(ComputeActivity2.this, List.class);
                listScreen.putExtras(b);
                startActivity(listScreen);
            }
        });
    }

   /* @Override
    protected void onResume() {
        super.onResume();
        Bundle resume = getIntent().getExtras();
        name = resume.getString("Name");
        price = resume.getString("Price");
        quantity = resume.getString("Quantity");
        totalPrice = resume.getString("totalPrice");

        double priceNum = Double.parseDouble(price);
        double result = Double.parseDouble(totalPrice);
        double quantityNum = Double.parseDouble(quantity);
        double taxNum = Double.parseDouble(tax);
        double Total = (priceNum*quantityNum) + (priceNum*quantityNum*taxNum)/100;
        double grandTotal = Total + result;

        n.setText(name);
        pr.setText(String.format("$%,.2f", priceNum));
        tp.setText(String.format("$%,.2f", grandTotal));
        q.setText(String.format("%.0f", quantityNum));
        t.setText(String.format("%5.2f", taxNum));
    }*/
}