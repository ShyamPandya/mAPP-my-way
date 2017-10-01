package com.example.shyam.mappmyway;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

/**
 * Created by shyam on 13/9/17.
 */

public class camera extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    private static final String TAG = "";
    private ImageView iv;
    private JSONObject json_object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        this.iv=(ImageView)this.findViewById(R.id.imageView);
        try {
            json_object = new JSONObject(getIntent().getStringExtra("JOBJ"));

            Log.e(TAG, "Example Item: " + json_object.getString("KEY"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonStr = json_object.toString();

        System.out.println("jsonString: "+jsonStr);

        Button photoButton = (Button) this.findViewById(R.id.button1);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            String img=getStringFromBitmap(photo);
            iv.setImageBitmap(photo);
            System.out.println("THE IMAGE STRING IS " + img);
            try {
                json_object.put("image",img);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Intent i =new Intent(getApplicationContext(),Confirmcomp.class);
            i.putExtra("JOBJ",json_object.toString());
            startActivity(i);
        }
    }

    private String getStringFromBitmap(Bitmap bitmapPicture) {
 /*
 * This functions converts Bitmap picture to a string which can be
 * JSONified.
 * */
        final int COMPRESSION_QUALITY = 100;
        String encodedImage;
        ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
        bitmapPicture.compress(Bitmap.CompressFormat.PNG, COMPRESSION_QUALITY,
                byteArrayBitmapStream);
        byte[] b = byteArrayBitmapStream.toByteArray();
        encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
        return encodedImage;
    }
}

/*
    Button ib = (Button) findViewById(R.id.button);
        ib.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View view) {
        try {
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
        }
        });
*/