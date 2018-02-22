package com.example.jh949711.computeprice;
/*
This class holds the list of the items add after the list button is pushed
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jh949711 on 2/21/18.
 */

public class List extends AppCompatActivity {
    TextView ItemList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ItemList = findViewById(R.id.itemList);
        Bundle b = this.getIntent().getExtras();
        ArrayList<String> nameArray = b.getStringArrayList("nameArray");
        ArrayList<String> priceArray = b.getStringArrayList("priceArray");
        ArrayList<String> quantityArray = b.getStringArrayList("quantityArray");
        for (int i = 0; nameArray.size() >= i; i++) {
            String name = nameArray.get(i);
            String price = priceArray.get(i);
            String quantity = quantityArray.get(i);
            ItemList.setText("" + name + price + quantity);
        }

    }


}
