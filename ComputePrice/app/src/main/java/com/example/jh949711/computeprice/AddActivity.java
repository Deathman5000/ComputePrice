package com.example.jh949711.computeprice;
/*
This class is what happens after the add button is pushed.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by jh949711 on 2/21/18.
 */

public class AddActivity extends AppCompatActivity {

        EditText name, price, quantity;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add);

            name = findViewById(R.id.addName);
            price = findViewById(R.id.addPrice);
            quantity = findViewById(R.id.addQuantity);

            String n = name.getText().toString();
            double pr = Double.parseDouble(price.getText().toString());
            double q = Double.parseDouble(quantity.getText().toString());
            name.setText(n);
            price.setText(String.format("$%,.2f", pr));
            quantity.setText(String.format("%.0f", q));


            Intent intent1 = new Intent(AddActivity.this, ComputeActivity.class );
                intent1.putExtra("Name", n);
                intent1.putExtra("Price", pr);
                intent1.putExtra("Quantity", q);

                //startActivityForResult( intent1, );
        }

}
