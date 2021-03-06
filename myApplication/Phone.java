package com.example.myapplication;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Phone extends AppCompatActivity {



    private EditText mCountrycode;
    private EditText mPhoneNumber;

    private Button mGeneratbtn;
    private ProgressBar mLoginProgress;

    private FirebaseUser mCurrentUser;
    private  FirebaseAuth mAuth;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks McallBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        mCountrycode = findViewById(R.id.country_code_et);
        mPhoneNumber = findViewById(R.id.Mobile_Number_et);
        mGeneratbtn = findViewById(R.id.button_generate_otp);
        mLoginProgress = findViewById(R.id.generate_progress_bar);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();


        mGeneratbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country_code = mCountrycode.getText().toString();
                String phone_number = mPhoneNumber.getText().toString();

                String complete_phone_number = "+"+country_code + phone_number;

                if (country_code.isEmpty() || phone_number.isEmpty() ){
                    Toast.makeText(getApplicationContext(),"Please Fill",Toast.LENGTH_LONG).show();
                }else {
                    mLoginProgress.setVisibility(View.VISIBLE);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            complete_phone_number,
                            60,
                            TimeUnit.SECONDS,
                            Phone.this,
                            McallBack
                    );
                }
            }
        });
        McallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredentials(phoneAuthCredential);
            }



            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

                Toast.makeText(getApplicationContext(),"verification Failed",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                Toast.makeText(getApplicationContext(),"sent ",Toast.LENGTH_LONG).show();

                Intent otpIntent = new Intent(Phone.this,otpactivity.class);
                otpIntent.putExtra("AuthCredentials",s);
                startActivity(otpIntent);

            }
        };



    }

    private void signInWithPhoneAuthCredentials(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(Phone.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            sendUserhome();
                        }else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                                Toast.makeText(getApplicationContext(),"error In verifying OTP",Toast.LENGTH_LONG).show();
                            }
                        }
                        mLoginProgress.setVisibility(View.VISIBLE);
                    }
                });
    }

    private void sendUserhome(){
        Intent homeIntent = new Intent(Phone.this,Login.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mCurrentUser != null){
            sendUserhome();
        }

    }
}
