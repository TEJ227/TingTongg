package com.rsolutions.tingtongg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class LocationSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selector);

        Button DetectLoc= (Button)findViewById(R.id.locate_me);
        DetectLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence toastMessage= "Feature Coming Soon..";

                Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Button SelectLocation=(Button)findViewById(R.id.select_loc);
        SelectLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocationSelector.this,LocationActivity.class);
                startActivity(intent);
            }
        });

    }
}