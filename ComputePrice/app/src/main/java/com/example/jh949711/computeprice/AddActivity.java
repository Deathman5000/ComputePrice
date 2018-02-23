package com.example.jh949711.computeprice;
/*
This class is what happens after the add button is pushed.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jh949711 on 2/21/18.
 */

public class AddActivity extends AppCompatActivity {

        EditText aname, aprice, aquantity;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add);


            /*Intent intent1 = new Intent(AddActivity.this, List.class );
                intent1.putExtra("Name", n);
                //intent1.putExtra("Price", pr);
                //intent1.putExtra("Quantity", q);*/

                //startActivity( intent1 );
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();

            aname = findViewById(R.id.addName);
            aprice = findViewById(R.id.addPrice);
            aquantity = findViewById(R.id.addQuantity);

            String n = aname.getText().toString();
            double pr = Double.parseDouble(aprice.getText().toString());
            double q = Double.parseDouble(aquantity.getText().toString());
            //aname.setText(n);
            //aprice.setText(String.format("$%,.2f", pr));
            //aquantity.setText(String.format("%.0f", q));
        }
}
