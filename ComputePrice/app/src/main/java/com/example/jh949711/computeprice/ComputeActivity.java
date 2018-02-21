/*
    App: Compute Price
    Authors: Kyra Belanger, James Hund
    Version: 02/21/18
    Description:
 */
package com.example.jh949711.computeprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComputeActivity extends AppCompatActivity {

    EditText name, price, quantity, tax, totalPrice;
    Button compute, add, list;

/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                name = data.getExtras().getInt("name");
                price = data.getExtras().getInt("price");
                quantity = data.getExtras().getInt("quantity");
                tax = data.getExtras().getInt("tax");
                totalPrice = data.getExtras().getInt("totalPrice");
            }
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        tax = findViewById(R.id.tax);
        totalPrice = findViewById(R.id.totalPrice);
        compute = findViewById(R.id.computeButton);
        add = findViewById(R.id.addButton);
        list = findViewById(R.id.addButton);
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("")){
                    Toast.makeText(ComputeActivity.this, "No Name entered",
                            Toast.LENGTH_SHORT).show();
                }
                if(price.getText().toString().equals("")){
                    Toast.makeText(ComputeActivity.this, "No Price entered",
                            Toast.LENGTH_SHORT).show();
                }
                else if(quantity.getText().toString().equals("")){
                    Toast.makeText(ComputeActivity.this, "No Quantity entered",
                            Toast.LENGTH_SHORT).show();
                }
                else if(tax.getText().toString().equals("")){
                    Toast.makeText(ComputeActivity.this, "No Tax entered",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    String n = name.getText().toString();
                    double pr = Double.parseDouble(price.getText().toString());
                    double q = Double.parseDouble(quantity.getText().toString());
                    double t = Double.parseDouble(tax.getText().toString());
                    double result = (pr*q) + (pr*q*t)/100;

                    name.setText(n);
                    totalPrice.setText(String.format("$%,.2f", result));
                    price.setText(String.format("$%,.2f", pr));
                    quantity.setText(String.format("%.0f", q));
                    tax.setText(String.format("%5.2f", t));

                    Intent intent = new Intent(ComputeActivity.this, ComputeActivity2.class);
                            intent.putExtra("name",n);
                            intent.putExtra("totalPrice",result);
                            intent.putExtra("price",pr);
                            intent.putExtra("quantity",q);
                            intent.putExtra("tax",t);
                            //startActivityForResult(intent,MY_REQUEST_CODE);
                }
            }
        });
    }
}
