package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity {
    int vag_num=0;
    int gian_num=0;
    int fior_num=0;
    int mista_num=0;
    int noci_num=0;
    int pist_num=0;
    int coco_num=0;
    int cio_num=0;
    int pera_num=0;
    int mand_num=0;
    int lim_num=0;
    int liq_num=0;

    int tot=0;
    private FirebaseAuth mAuth;
    Button signout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(Login.this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextView count=(TextView)findViewById(R.id.gusti_count);

        final TextView vag_count=(TextView)findViewById(R.id.vag_count);
        final TextView gian_count=(TextView)findViewById(R.id.gian_count);
        final TextView fior_count=(TextView)findViewById(R.id.fior_count);
        final TextView mista_count=(TextView)findViewById(R.id.mista_count);
        final TextView noci_count=(TextView)findViewById(R.id.noci_count);
        final TextView pist_count=(TextView)findViewById(R.id.pist_count);
        final TextView coco_count=(TextView)findViewById(R.id.coco_count);
        final TextView cio_count=(TextView)findViewById(R.id.cio_count);
        final TextView pera_count=(TextView)findViewById(R.id.pera_count);
        final TextView man_count=(TextView)findViewById(R.id.man_count);
        final TextView lim_count=(TextView)findViewById(R.id.lim_count);
        final TextView liq_count=(TextView)findViewById(R.id.liq_count);
        //final CustomerModel customerModel = new CustomerModel[1];

        final String value=getIntent().getStringExtra("stuff");
        Button buttonOne = findViewById(R.id.Cassa);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                    if(vag_num>0) {
                        for(int i=0; i<vag_num;i++) {

                            CustomerModel customerModel;
                            try {
                                customerModel = new CustomerModel(100, "Vanila",1 , " ");

                                //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                                customerModel = new CustomerModel();
                            }
                            DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                            boolean success = dataBaseHelper.addOne(customerModel);
                            //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                            //makecustomerView(dataBaseHelper);
                        } }
                    //gian
                if(gian_num>0) {
                    for(int i=0; i<gian_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "ciocolatto gianduia",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }
                if(fior_num>0) {
                    for(int i=0; i<fior_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "fior di latte",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }

                if(mista_num>0) {
                    for(int i=0; i<mista_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "mista bosca",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }

                if(noci_num>0) {
                    for(int i=0; i<noci_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "noci",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }

                if(pist_num>0) {
                    for(int i=0; i<pist_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "pistaccio",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }

                if(coco_num>0) {
                    for(int i=0; i<coco_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "coco",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }

                if(cio_num>0) {
                    for(int i=0; i<cio_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "ciocolatto",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }

                if(pera_num>0) {
                    for(int i=0; i<pera_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "pera",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }


                if(mand_num>0) {
                    for(int i=0; i<mand_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "mandora",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }

                if(lim_num>0) {
                    for(int i=0; i<lim_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "limone",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }

                if(liq_num>0) {
                    for(int i=0; i<liq_num;i++) {

                        CustomerModel customerModel;
                        try {
                            customerModel = new CustomerModel(100, "liqurish",1 , " ");

                            //Toast.makeText(Login.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            //Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            customerModel = new CustomerModel();
                        }
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);
                        boolean success = dataBaseHelper.addOne(customerModel);
                        //Toast.makeText(Login.this, "Success=" + success, Toast.LENGTH_SHORT).show();
                        //makecustomerView(dataBaseHelper);
                    } }

                Intent activity2Intent = new Intent(getApplicationContext(), sqlstuff.class);
                startActivity(activity2Intent);

        }});
        //signout
        signout=findViewById(R.id.button2);


        signout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Login.this, mainLogin.class);
                startActivity(intent);
                finish();
                FirebaseAuth.getInstance().signOut();

            }
        });

        //flavors options
        //vag
        Button button1a = findViewById(R.id.vag_plus);
        button1a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                vag_num++;
                tot++;
                vag_count.setText(""+vag_num);
                count.setText(""+tot);
            }
        });
        Button button1b = findViewById(R.id.vag_min);
        button1b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(vag_num>0){
                vag_num--;
            }
                tot--;
                vag_count.setText(""+vag_num);
                count.setText(""+tot);;
            }
        });
        //gianduia
        Button button2a = findViewById(R.id.gian_plus);
        button2a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                gian_num++;
                tot++;
                gian_count.setText(""+gian_num);
                count.setText(""+tot);
            }
        });
        Button button2b = findViewById(R.id.gian_min);
        button2b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(gian_num>0){
                gian_num--;
                tot--;
            }
                gian_count.setText(""+gian_num);
                count.setText(""+tot);;
            }
        });
        //fior
        Button button3a = findViewById(R.id.Fior_plus);
        button3a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                fior_num++;
                tot++;
                fior_count.setText(""+fior_num);
                count.setText(""+tot);
            }
        });
        Button button3b = findViewById(R.id.Fior_min);
        button3b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(fior_num>0){
                fior_num--;
                tot--;
            }
                fior_count.setText(""+fior_num);
                count.setText(""+tot);;
            }
        });

        //mista
        Button button4a = findViewById(R.id.Misto_plus);
        button4a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                mista_num++;
                tot++;
                mista_count.setText(""+mista_num);
                count.setText(""+tot);
            }
        });
        Button button4b = findViewById(R.id.Misto_min);
        button4b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(mista_num>0){
                mista_num--;
                tot--;
            }
                mista_count.setText(""+mista_num);
                count.setText(""+tot);;
            }
        });

        //noci
        Button button5a = findViewById(R.id.Noci_plus);
        button5a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                noci_num++;
                tot++;
                noci_count.setText(""+noci_num);
                count.setText(""+tot);
            }
        });
        Button button5b = findViewById(R.id.Noci_min);
        button5b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(noci_num>0){
                noci_num--;
                tot--;
            }
                noci_count.setText(""+noci_num);
                count.setText(""+tot);;
            }
        });

        //pist
        Button button6a = findViewById(R.id.Pist_plus);
        button6a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                pist_num++;
                tot++;
                pist_count.setText(""+pist_num);
                count.setText(""+tot);
            }
        });
        Button button6b = findViewById(R.id.Pist_min);
        button6b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(pist_num>0){
                pist_num--;
                tot--;
            }
                pist_count.setText(""+pist_num);
                count.setText(""+tot);;
            }
        });

        //coco
        Button button7a = findViewById(R.id.coco_plus);
        button7a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                pist_num++;
                tot++;
                coco_count.setText(""+coco_num);
                count.setText(""+tot);
            }
        });
        Button button7b = findViewById(R.id.coco_min);
        button7b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(coco_num>0){
                coco_num--;
                tot--;
            }
                pist_count.setText(""+coco_num);
                count.setText(""+tot);;
            }
        });

        //cio
        Button button8a = findViewById(R.id.cio_plus);
        button8a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                cio_num++;
                tot++;
                cio_count.setText(""+cio_num);
                count.setText(""+tot);
            }
        });
        Button button8b = findViewById(R.id.cio_min);
        button8b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(cio_num>0){
                cio_num--;
                tot--;
            }
                cio_count.setText(""+cio_num);
                count.setText(""+tot);;
            }
        });

        //pera
        Button button9a = findViewById(R.id.pera_plus);
        button9a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                pera_num++;
                tot++;
                pera_count.setText(""+pera_num);
                count.setText(""+tot);
            }
        });
        Button button9b = findViewById(R.id.pera_min);
        button9b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(pera_num>0){
                pera_num--;
                tot--;
            }
                pera_count.setText(""+pera_num);
                count.setText(""+tot);;
            }
        });

        //mand
        Button button10a = findViewById(R.id.Man_plus);
        button10a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                mand_num++;
                tot++;
                man_count.setText(""+mand_num);
                count.setText(""+tot);
            }
        });
        Button button10b = findViewById(R.id.Man_min);
        button10b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(mand_num>0){
                mand_num--;
                tot--;
            }
                man_count.setText(""+mand_num);
                count.setText(""+tot);;
            }
        });

        //Lim
        Button button11a = findViewById(R.id.lim_plus);
        button11a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                lim_num++;
                tot++;
                lim_count.setText(""+lim_num);
                count.setText(""+tot);
            }
        });
        Button button11b = findViewById(R.id.lim_min);
        button11b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(lim_num>0) {
                lim_num--;
                tot--;
            }
                lim_count.setText(""+lim_num);
                count.setText(""+tot);;
            }
        });

        //Liq
        Button button12a = findViewById(R.id.liq_plus);
        button12a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                liq_num++;
                tot++;
                liq_count.setText(""+liq_num);
                count.setText(""+tot);
            }
        });
        Button button12b = findViewById(R.id.liq_min);
        button12b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                if(liq_num>0){
                liq_num--;
                tot--;
                }
                liq_count.setText(""+liq_num);
                count.setText(""+tot);;

        }});


        }



        }



