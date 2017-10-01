package com.example.shyam.mappmyway;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

/**
 * Created by shyam on 13/9/17.
 */


public class complaints extends AppCompatActivity {
    private static int id;
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText desc;
    private JSONObject student1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaint);
        Button ib = (Button) findViewById(R.id.button);
        name =(EditText)findViewById(R.id.editText2);
        phone =(EditText)findViewById(R.id.editText3);
        email =(EditText)findViewById(R.id.editText);
        desc=(EditText)findViewById(R.id.editText4);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    student1=new JSONObject();
                    student1.put("id", id);
                    student1.put("name", name.getText().toString());
                    student1.put("phone", phone.getText().toString());
                    student1.put("email", email.getText().toString());
                    student1.put("desc", desc.getText().toString());

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                id++;
                String jsonStr = student1.toString();

                System.out.println("jsonString: "+jsonStr);
                Intent i =new Intent(getApplicationContext(),camera.class);
                i.putExtra("JOBJ",student1.toString());
                startActivity(i);
            }
        });

    }

    
}
