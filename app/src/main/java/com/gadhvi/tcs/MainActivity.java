package com.gadhvi.tcs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=(Button)findViewById(R.id.unlock_car);
        b=(Button)findViewById(R.id.Lock_Car);
        c=(Button)findViewById(R.id.map);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x=new Intent(getBaseContext(),Finger_Auth.class);
                startActivity(x);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Car_1").child("Lock_Status");
                myRef.setValue("0");

            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z=new Intent(getBaseContext(),mMap.class);
                startActivity(z);
            }
        });

    }
}
