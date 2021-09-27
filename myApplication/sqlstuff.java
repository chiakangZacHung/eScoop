package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class sqlstuff extends AppCompatActivity {
    Button btn_add, btn_viewAll;
    EditText et_name,et_age;
    Switch sw_activeCustomer;
    ListView lv_customerList;
    ArrayAdapter customerArrayAdapter;
    DataBaseHelper dataBaseHelper;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    DatabaseReference name;
    Button continuenow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlstuff);
        rootNode=FirebaseDatabase.getInstance();
        btn_add=findViewById((R.id.btn_add));
        btn_viewAll=findViewById((R.id.btn_viewAll));
        et_age=findViewById((R.id.et_age));
        et_name=findViewById((R.id.et_name));
        sw_activeCustomer=findViewById(R.id.sw_activeCustomer);
        lv_customerList=findViewById(R.id.lv_customerList);
        final TextView val=(TextView)findViewById(R.id.val);
        continuenow=findViewById(R.id.continuenow);



        dataBaseHelper=new DataBaseHelper((sqlstuff.this));
        makecustomerView(dataBaseHelper);


        btn_viewAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final DataBaseHelper dataBaseHelper=new DataBaseHelper(sqlstuff.this);
                val.setText("Calculating..");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        val.setText("Total cost:"+dataBaseHelper.getEveryOne().size()*1.5);
                    }
                },1500);


                //makecustomerView(dataBaseHelper);
//                reference=rootNode.getReference("users");
//                VanillaHelper stuff=new VanillaHelper("loooo", "eeee", "","adfasddf");
//                reference.child("username").push().setValue(stuff);
                //Toast.makeText(sqlstuff.this,everyone.toString(),Toast.LENGTH_SHORT).show();
//                reference=rootNode.getReference("username");
//
//                if(reference.equals("zac.zac.zac5@gmail.com"));
//                 //name.child("items").setValue(dataBaseHelper.getEveryOne().toString());
//                reference.child("items").setValue("ego");
//                Intent activity2Intent = new Intent(getApplicationContext(), Carrello.class);
//                startActivity(activity2Intent);


            }});
        continuenow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(dataBaseHelper.getEveryOne().size()%6!=0) {
                    Toast.makeText(getApplicationContext(), "In a multiple of six please", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(sqlstuff.this, Carrello.class);
                    //Create the bundle
                    Bundle bundle = new Bundle();

//Add your data to bundle
                    intent.putExtra("stuff", dataBaseHelper.getEveryOne()+"");
                    startActivity(intent);
                    finish();



                }
            }});
        lv_customerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomerModel clickedCustomer= (CustomerModel) parent.getItemAtPosition(position);
                dataBaseHelper.DeleteOne(clickedCustomer);
                makecustomerView(dataBaseHelper);

            }
        });

    }

    private void makecustomerView(DataBaseHelper dataBaseHelper2) {
        customerArrayAdapter = new ArrayAdapter<CustomerModel>(sqlstuff.this, android.R.layout.simple_list_item_1, dataBaseHelper2.getEveryOne());

        lv_customerList.setAdapter(customerArrayAdapter);
    }
}
