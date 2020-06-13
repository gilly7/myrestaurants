package com.example.myrestaurants;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] restaurants = new String[] {"Silibwet Role Modern", "Cricket", "Hawthorne Fish House", "Viking Soul Food",
            "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell", "Me Kha Noodle Bar",
            "La Bonita Taqueria", "Smokehouse Tavern", "Pembiche", "Kay's Bar", "Gnarly Grey", "Slappy Cakes", "Mi Mero Mole" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        mListView = findViewById(R.id.listView);
        mLocationTextView = findViewById(R.id.locationTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, restaurants);
        mListView.setAdapter(adapter); // set our ListView adapter to the new adapter:

        mListView.setOnItemClickListener((adapterView, view, i, l) -> {
            String restaurant = ((TextView)view).getText().toString();
            Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the restaurants near: " + location);
    }
}
