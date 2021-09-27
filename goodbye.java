package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class goodbye extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager mCallbackManager;
    private FirebaseAuth mAuth;
    private final static int RC_SIGN_IN=123;
    private GoogleSignInClient mGoogleSignInClient;
    public boolean signed_in=false;
    SignInButton changeButtonText;
    Button signout;


    protected void onStart(){
        super.onStart();
        FirebaseUser user=mAuth.getCurrentUser();
        if(user!=null){
            Intent intent=new Intent(getApplicationContext(),Welcome.class);
        }
        //check if the account is signed in
        if(mAuth.getCurrentUser()!=null) {
            //go to another screen
            Intent intent = new Intent(goodbye.this, Carrello.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        createRequest();


        changeButtonText=findViewById(R.id.google_signIn);
        signout=findViewById(R.id.button2);

        changeButtonText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                signIn();

            }
        });

        signout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                FirebaseAuth.getInstance().signOut();

            }
        });
        mAuth=FirebaseAuth.getInstance();


        // Initialize Facebook Login button
        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();



    }
    private void createRequest() {
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }
    private void signIn() {
        signed_in=true;
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);

                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                // ...
            }
        }
    }
    //authenticate google
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();

                            //Intent intent=new Intent(getApplicationContext(),Welcome.class);
                            //startActivity(intent);
                            Context context = getApplicationContext();
                            CharSequence text = "Log-in successfully";

                            //set time either short or long for the duration of the message
                            int duration = Toast.LENGTH_SHORT;
                            //set text
                            Toast toast = Toast.makeText(context, text, duration);
                            //display text
                            toast.show();

                        } else {
                            // If sign in fails, display a message to the user.



                        }

                        // ...
                    }
                });
    }
}
