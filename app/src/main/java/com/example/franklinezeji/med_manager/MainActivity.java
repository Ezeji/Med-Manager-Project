package com.example.franklinezeji.med_manager;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    private EditText EditText1;
    private EditText EditText2;
    private EditText EditText3;
    private EditText EditText4;
    private EditText EditText5;
    private Button SubmitButton;

    private String Username;
    public static final String ANONYMOUS = "anonymous";


    public FirebaseDatabase FirebaseDatabase;
    public DatabaseReference DatabaseReference;


    public static final int RC_SIGN_IN = 1;
    private com.google.firebase.auth.FirebaseAuth FirebaseAuth;
    private FirebaseAuth.AuthStateListener AuthStateListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = ANONYMOUS;


        FirebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseAuth = FirebaseAuth.getInstance();

        DatabaseReference = FirebaseDatabase.getReference().child("Database/Medication Details");

        //initialize references with views
        EditText1 = (EditText) findViewById(R.id.edit_text1);
        EditText2 = (EditText) findViewById(R.id.edit_text2);
        EditText3 = (EditText) findViewById(R.id.edit_text3);
        EditText4 = (EditText) findViewById(R.id.edit_text4);
        EditText5 = (EditText) findViewById(R.id.edit_text5);
        SubmitButton = (Button) findViewById(R.id.submit_button);

        // Submit button sends a message and clears the EditText
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Send messages on click

                Information information_object = new Information(EditText1.getText().toString(), EditText2.getText().toString(), EditText3.getText().toString(), EditText4.getText().toString(), EditText5.getText().toString());

                DatabaseReference.push().setValue(information_object);


                // Clear input box
                EditText1.setText("");
                EditText2.setText("");
                EditText3.setText("");
                EditText4.setText("");
                EditText5.setText("");


                //calling method for explicit intent moving from first activity to second activity
                activate_next_activity();
            }
        });



        AuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {

                    onSignedInInitialize(user.getDisplayName());

                } else {

                    onSignedOutCleanup();

                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setTheme(R.style.FirebaseLoginTheme)
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(
                                            AuthUI.EMAIL_PROVIDER,
                                            AuthUI.GOOGLE_PROVIDER)
                                    .build(),
                            RC_SIGN_IN);

                }
            }


        };


    }

    @Override
    public void onActivityResult(int requestcode, int resultcode, Intent data) {
        super.onActivityResult(requestcode, resultcode, data);
        if (requestcode == RC_SIGN_IN) {

            if (resultcode == RESULT_OK) {

                Toast.makeText(this, "Signed in!", Toast.LENGTH_LONG).show();

            } else if (resultcode == RESULT_CANCELED) {

                Toast.makeText(this, "Signed in canceled!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }



    @Override
    protected void onPause() {

        super.onPause();

        if (AuthStateListener != null) {
            FirebaseAuth.removeAuthStateListener(AuthStateListener);

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseAuth.addAuthStateListener(AuthStateListener);
    }

    private void onSignedInInitialize(String username) {

        Username = username;

    }

    private void onSignedOutCleanup() {

        Username = ANONYMOUS;

    }



    //method to move from first activity to second activity
    private void activate_next_activity(){

        Intent intent = new Intent(this,Document.class);
        startActivity(intent);

    }

}
