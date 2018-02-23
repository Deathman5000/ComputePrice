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

    ArrayList<String> nameArray = new ArrayList<String>(100);
    ArrayList<String> priceArray = new ArrayList<String>(100);
    ArrayList<String> quantityArray = new ArrayList<String>(100);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        n = findViewById(R.id.name);
        pr = findViewById(R.id.price);
        q = findViewById(R.id.quantity);
        t = findViewById(R.id.tax);
        tp = findViewById(R.id.totalPrice);
        add = findViewById(R.id.addButton);
        list = findViewById(R.id.listButton);
        Bundle test = getIntent().getExtras();
        count = test.getInt("Count");
        //tax = test.getString("tax");
        //double taxNum = Double.parseDouble(tax);
        //if (getIntent().getExtras().getString("from").equals("ComputeActivity")) {
        if (count == 0) {
            Bundle extras = getIntent().getExtras();
            name = extras.getString("name");
            price = extras.getString("price");
            quantity = extras.getString("quantity");
            tax = extras.getString("tax");
            totalPrice = extras.getString("totalPrice");
            count = extras.getInt("Count");

            double priceNum = Double.parseDouble(price);
            double result = Double.parseDouble(totalPrice);
            double quantityNum = Double.parseDouble(quantity);
            double taxNum = Double.parseDouble(tax);

            n.setText(name);
            tp.setText(String.format("$%,.2f", result));
            pr.setText(String.format("$%,.2f", priceNum));
            q.setText(String.format("%.0f", quantityNum));
            t.setText(String.format("%5.2f", taxNum));

         /*   nameArray.add(count,name);
            //nameArray.add(Name);
            priceArray.add(count,price);
            //priceArray.add(Price);
            quantityArray.add(count,quantity);
            //quantityArray.add(Quanitity);
            Bundle b = new Bundle();
            b.putStringArrayList("nameArray",nameArray);
            b.putStringArrayList("priceArray",priceArray);
            b.putStringArrayList("quantityArray",quantityArray);*/
        }
        //}


        //else if (getIntent().getExtras().getString("from").equals("AddActivity")) {
      /*  if (count > 0) {
            Bundle extras2 = getIntent().getExtras();
            name = extras2.getString("Name");
            price = extras2.getString("Price");
            quantity = extras2.getString("Quantity");
        //    tax = extras2.getString("tax");
            totalPrice = extras2.getString("totalPrice");
            double priceNum = Double.parseDouble(price);
            double quantityNum = Double.parseDouble(quantity);
          //  double taxNum = Double.parseDouble(tax);
            double toAdd = Double.parseDouble(totalPrice);

            double result = (priceNum*quantityNum) + (priceNum*quantityNum*taxNum)/100;
            double grandTotal = toAdd + result;

            n.setText(name);
            tp.setText(String.format("$%,.2f", grandTotal));
            pr.setText(String.format("$%,.2f", priceNum));
            q.setText(String.format("%.0f", quantityNum));
            t.setText(String.format("%5.2f", taxNum));


        }*/
        //}






      /*  n.setText(name);
        tp.setText(String.format("$%,.2f", result));
        pr.setText(String.format("$%,.2f", priceNum));
        q.setText(String.format("%.0f", quantityNum));
        t.setText(String.format("%5.2f", taxNum));*/




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             /*   Bundle b = new Bundle();
                b.putStringArrayList("nameArray",nameArray);
                b.putStringArrayList("priceArray",priceArray);
                b.putStringArrayList("quantityArray",quantityArray);*/

                Intent addScreen = new Intent(ComputeActivity2.this,AddActivity.class);
                count++;
                addScreen.putExtra("count",count);
                addScreen.putExtra("addTax",tax);
                addScreen.putExtra("addTotal",totalPrice);
               // addScreen.putExtras(b);
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

    @Override
    protected void onResume() {
        super.onResume();
        if (count > 0) {
            int index = 1;
            Bundle extras2 = getIntent().getExtras();
            name = extras2.getString("Name");
            price = extras2.getString("Price");
            quantity = extras2.getString("Quantity");
            tax = extras2.getString("addTax");
            totalPrice = extras2.getString("addTotal");
            nameArray = extras2.getStringArrayList("ListNameArray");
            priceArray = extras2.getStringArrayList("ListPriceArray");
            quantityArray = extras2.getStringArrayList("ListQuantityArray");
            double priceNum = Double.parseDouble(price);
            double quantityNum = Double.parseDouble(quantity);
            double taxNum = Double.parseDouble(tax);
            double toAdd = Double.parseDouble(totalPrice);

            double result = (priceNum*quantityNum) + (priceNum*quantityNum*taxNum)/100;
            double grandTotal = toAdd + result;

            n.setText(name);
            tp.setText(String.format("$%,.2f", grandTotal));
            pr.setText(String.format("$%,.2f", priceNum));
            q.setText(String.format("%.0f", quantityNum));
            t.setText(String.format("%5.2f", taxNum));



         /*   nameArray.add(index,name);
            //nameArray.add(Name);
            priceArray.add(index,price);
            //priceArray.add(Price);
            quantityArray.add(index,quantity);
            index++;*/
            //quantityArray.add(Quanitity);
            Bundle b = new Bundle();
            b.putStringArrayList("nameArray",nameArray);
            b.putStringArrayList("priceArray",priceArray);
            b.putStringArrayList("quantityArray",quantityArray);

        }
    }
}