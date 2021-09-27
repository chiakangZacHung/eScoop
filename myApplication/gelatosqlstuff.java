package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class gelatosqlstuff extends AppCompatActivity {
    Button btn_add, btn_viewAll;
    EditText et_name,et_age;
    Switch sw_activeCustomer;
    ListView lv_customerList;
    ArrayAdapter customerArrayAdapter;
    gelatoDataBaseHelper dataBaseHelper;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelatosqlstuff);
        rootNode=FirebaseDatabase.getInstance();
        btn_add=findViewById((R.id.btn_add));
        btn_viewAll=findViewById((R.id.btn_viewAll));
        et_age=findViewById((R.id.et_age));
        et_name=findViewById((R.id.et_name));
        sw_activeCustomer=findViewById(R.id.sw_activeCustomer);
        lv_customerList=findViewById(R.id.lv_customerList);

        dataBaseHelper=new gelatoDataBaseHelper((gelatosqlstuff.this));
        makecustomerView(dataBaseHelper);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gelatoCustomerModel customerModel;
                try{
                    customerModel= new gelatoCustomerModel(-1,et_name.getText().toString(),Integer.parseInt(et_age.getText().toString()));
                    Toast.makeText(gelatosqlstuff.this,customerModel.toString(),Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(gelatosqlstuff.this,"error",Toast.LENGTH_SHORT).show();
                    customerModel= new gelatoCustomerModel(-1,"error",0);
                }
                gelatoDataBaseHelper dataBaseHelper=new gelatoDataBaseHelper(gelatosqlstuff.this);
                boolean success=dataBaseHelper.addOne(customerModel);
                Toast.makeText(gelatosqlstuff.this,"Success="+success,Toast.LENGTH_SHORT).show();
                makecustomerView(dataBaseHelper);
            }
        });
        btn_viewAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gelatoDataBaseHelper dataBaseHelper=new gelatoDataBaseHelper(gelatosqlstuff.this);

                makecustomerView(dataBaseHelper);
                //Toast.makeText(gelatosqlstuff.this,everyone.toString(),Toast.LENGTH_SHORT).show();
                reference=rootNode.getReference("users");
                reference.child("address").setValue(dataBaseHelper.getEveryOne().toString());



            }});
        lv_customerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gelatoCustomerModel clickedCustomer= (gelatoCustomerModel) parent.getItemAtPosition(position);
                dataBaseHelper.DeleteOne(clickedCustomer);
                makecustomerView(dataBaseHelper);

            }
        });

    }

    private void makecustomerView(gelatoDataBaseHelper dataBaseHelper2) {
        customerArrayAdapter = new ArrayAdapter<gelatoCustomerModel>(gelatosqlstuff.this, android.R.layout.simple_list_item_1, dataBaseHelper2.getEveryOne());
        lv_customerList.setAdapter(customerArrayAdapter);
    }
}
