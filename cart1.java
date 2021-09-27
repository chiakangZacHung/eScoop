package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class cart1 extends AppCompatActivity {
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private String token;
    private int count;
    private int clicks;
    private int total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart1);
        Button buttonOne = findViewById(R.id.menu);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activity3Intent = new Intent(getApplicationContext(), Login.class);
                startActivity(activity3Intent);
            }
        });
        Button button1 = findViewById(R.id.description);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), Description1.class);
                startActivity(activity2Intent);
            }
        });
        Button button2 = findViewById(R.id.cart);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                token=UUID.randomUUID().toString();
                rootNode=FirebaseDatabase.getInstance();

                reference=rootNode.getReference("users");
                if(count==0) {
                    token=UUID.randomUUID().toString();
                    count++;
                   }

                VanillaHelper help=new VanillaHelper("app","app",Integer.toString(total),"app");

                reference.setValue(help);
                System.out.println("Button Clicked");
                Intent activity2Intent = new Intent(getApplicationContext(), Carrello.class);
                startActivity(activity2Intent);

            }
        });
        ImageButton button3 = findViewById(R.id.quantity);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks++;
                total=clicks*83;



                System.out.println("Button Clicked");

                Toast.makeText(cart1.this,"Tutti:"+total,Toast.LENGTH_LONG).show();
            }
        });

    }

}
