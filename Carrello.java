package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Carrello extends AppCompatActivity {
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String greatness;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrello);
        final EditText address=(EditText) findViewById(R.id.address);
        Button coupon=findViewById(R.id.coupon);
        Button submittthis=findViewById(R.id.submittthis);
        Bundle bundle = getIntent().getExtras();
        Bundle bundle2 = getIntent().getExtras();
        rootNode=FirebaseDatabase.getInstance();
        final EditText first=findViewById(R.id.first);
        final EditText second=findViewById(R.id.second);

//Extract the data…
        try {
            String stuff = bundle.getString("stuff");

            String stuffy = bundle2.getString("stuffy");
            System.out.println("this is very" + stuff);
            System.out.println("this is lo" + stuffy);
            address.setText(stuffy);
            greatness=stuff;
        }
     catch (Exception e)

    {
    }
        Button currentlocation = findViewById(R.id.currentlocation);
        currentlocation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                Intent activity2Intent = new Intent(Carrello.this,MapsActivity.class);
                startActivity(activity2Intent);
            }
        });

        coupon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Carrello.this, Register.class);
                //Create the bundle

                startActivity(intent);
                finish();



            }
        });
        submittthis.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Carrello.this, Login.class);

                reference=rootNode.getReference("users");
                VanillaHelper stuff=new VanillaHelper(first.getText().toString(), address.getText().toString(), second.getText().toString(),greatness);
                reference.child("number").push().setValue(stuff);




                Intent activity2Intent = new Intent(getApplicationContext(), Carrello.class);
                startActivity(activity2Intent);
                CharSequence text = "Order made successfully";

                //set time either short or long for the duration of the message
                int duration = Toast.LENGTH_LONG;
                //set text
                Toast toast = Toast.makeText(Carrello.this, text, duration);
                //display text
                toast.show();
                //Create the bundle

                startActivity(intent);
                finish();



            }
        });






}}

