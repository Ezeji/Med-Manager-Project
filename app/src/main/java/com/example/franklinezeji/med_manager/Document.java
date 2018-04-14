package com.example.franklinezeji.med_manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Franklin Ezeji on 4/3/2018.
 */

public class Document extends AppCompatActivity {



    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioButton radioButton7;
    private RadioButton radioButton8;
    private RadioButton radioButton9;
    private RadioButton radioButton10;
    private RadioButton radioButton11;
    private RadioButton radioButton12;
    private RadioButton radioButton13;
    private RadioButton radioButton14;
    private Button sendbutton;




    public FirebaseDatabase FirebaseDatabase2;
    private DatabaseReference DatabaseReference2;




    WeeklyInformation weeklyInformation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);




        FirebaseDatabase2 = FirebaseDatabase.getInstance();


        DatabaseReference2 = FirebaseDatabase2.getReference().child("Database/Weekly Record");



        //initialize references with views
        radioButton1 = (RadioButton) findViewById(R.id.R_button1);
        radioButton2 = (RadioButton) findViewById(R.id.R_button2);
        radioButton3 = (RadioButton) findViewById(R.id.R_button3);
        radioButton4 = (RadioButton) findViewById(R.id.R_button4);
        radioButton5 = (RadioButton) findViewById(R.id.R_button5);
        radioButton6 = (RadioButton) findViewById(R.id.R_button6);
        radioButton7 = (RadioButton) findViewById(R.id.R_button7);
        radioButton8 = (RadioButton) findViewById(R.id.R_button8);
        radioButton9 = (RadioButton) findViewById(R.id.R_button9);
        radioButton10 = (RadioButton) findViewById(R.id.R_button10);
        radioButton11 = (RadioButton) findViewById(R.id.R_button11);
        radioButton12 = (RadioButton) findViewById(R.id.R_button12);
        radioButton13 = (RadioButton) findViewById(R.id.R_button13);
        radioButton14 = (RadioButton) findViewById(R.id.R_button14);
        sendbutton = (Button) findViewById(R.id.send_button);

        weeklyInformation = new WeeklyInformation();




        // Send button sends a message and clears the checkboxes
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Send messages on click




                DatabaseReference2.push().setValue(weeklyInformation);

                Toast.makeText(Document.this, "Your weekly record was sent successfully!",
                        Toast.LENGTH_LONG).show();


                weeklyInformation.result1 = "";
                weeklyInformation.result2 = "";
                weeklyInformation.result3 = "";
                weeklyInformation.result4 = "";
                weeklyInformation.result5 = "";
                weeklyInformation.result6 = "";
                weeklyInformation.result7 = "";
                weeklyInformation.result8 = "";
                weeklyInformation.result9 = "";
                weeklyInformation.result10 = "";
                weeklyInformation.result11 = "";
                weeklyInformation.result12 = "";
                weeklyInformation.result13 = "";
                weeklyInformation.result14 = "";


            }
        });


        }


    //method to move from second activity to first activity
    private void activate_previous_activity(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.back_menu:
                activate_previous_activity();

            default:
                return super.onOptionsItemSelected(item);
        }

    }



    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.R_button1:
                if (checked)

                    weeklyInformation.radiobutton1(radioButton1.getText().toString());

                    break;
            case R.id.R_button2:
                if (checked)

                    weeklyInformation.radiobutton2(radioButton2.getText().toString());

                    break;
        }
    }

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.R_button3:
                if (checked)

                    weeklyInformation.radiobutton3(radioButton3.getText().toString());

                break;
            case R.id.R_button4:
                if (checked)

                    weeklyInformation.radiobutton4(radioButton4.getText().toString());

                break;
        }
    }

    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.R_button5:
                if (checked)

                    weeklyInformation.radiobutton5(radioButton5.getText().toString());

                break;
            case R.id.R_button6:
                if (checked)

                    weeklyInformation.radiobutton6(radioButton6.getText().toString());

                break;
        }
    }

    public void onRadioButtonClicked4(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.R_button7:
                if (checked)

                    weeklyInformation.radiobutton7(radioButton7.getText().toString());

                break;
            case R.id.R_button8:
                if (checked)

                    weeklyInformation.radiobutton8(radioButton8.getText().toString());

                break;
        }
    }

    public void onRadioButtonClicked5(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.R_button9:
                if (checked)

                    weeklyInformation.radiobutton9(radioButton9.getText().toString());

                break;
            case R.id.R_button10:
                if (checked)

                    weeklyInformation.radiobutton10(radioButton10.getText().toString());

                break;
        }
    }

    public void onRadioButtonClicked6(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.R_button11:
                if (checked)

                    weeklyInformation.radiobutton11(radioButton11.getText().toString());

                break;
            case R.id.R_button12:
                if (checked)

                    weeklyInformation.radiobutton12(radioButton12.getText().toString());

                break;
        }
    }

    public void onRadioButtonClicked7(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.R_button13:
                if (checked)

                    weeklyInformation.radiobutton13(radioButton13.getText().toString());

                break;
            case R.id.R_button14:
                if (checked)

                    weeklyInformation.radiobutton14(radioButton14.getText().toString());

                break;
        }
    }



}



