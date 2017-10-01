package com.example.shyam.mappmyway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton ib= (ImageButton)findViewById(R.id.dustbin);
        ImageButton ib2= (ImageButton)findViewById(R.id.schools);
        ImageButton ib3= (ImageButton)findViewById(R.id.hospitals);
        ImageButton ib4= (ImageButton)findViewById(R.id.complaints);

        ib.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                Intent i =new Intent(getApplicationContext(),dustbins.class);
                startActivity(i);

            }
        });
        ib2.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                Intent i =new Intent(getApplicationContext(),schools.class);
                startActivity(i);

            }
        });
        ib3.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                Intent i =new Intent(getApplicationContext(),hospitals.class);
                startActivity(i);

            }
        });
        ib4.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                Intent i =new Intent(getApplicationContext(),complaints.class);
                startActivity(i);

            }
        });
    }
}
