package com.example.lutsak.rotation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    private int mCount = 0;
    Contact mContact;
    Button countButton;
    Button setNameButton;
    Button showName;
    Button goWeb;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, ">> onCreate");

        countButton = findViewById(R.id.button1);
        setNameButton = findViewById(R.id.setName);
        showName = findViewById(R.id.showName);
        goWeb = findViewById(R.id.button_web);
        goWeb.setOnClickListener(this);
        showName.setOnClickListener(this);
        countButton.setOnClickListener(this);
        setNameButton.setOnClickListener(this);

        if (mContact == null) {
            mContact = new Contact();
        }

        Log.d(LOG_TAG, "<< onCreate");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(LOG_TAG, ">> onRestoreInstanceState");

        mCount = savedInstanceState.getInt("mCount");
        mContact = (Contact) getLastCustomNonConfigurationInstance();

        Log.d(LOG_TAG, "<< onRestoreInstanceState");
    }

    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume ");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("mCount", mCount);

        Log.d(LOG_TAG, "onSaveInstanceState");
    }

    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onClick(View v) {
        EditText nameText = findViewById(R.id.editName);
        switch (v.getId()) {
            case R.id.button1:
                Toast.makeText(this, "Count = " + ++mCount, Toast.LENGTH_SHORT).show();
                Log.d(LOG_TAG, "Toast count: " + mCount);
                break;
            case R.id.setName:
                mContact.name = nameText.getText().toString();
                Log.d(LOG_TAG, "Contact name setted!");
                break;
            case R.id.showName:
                Toast.makeText(this, mContact.name, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_web:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(Intent.createChooser(intent, "Choose Program"));
        }
    }

    public Object onRetainCustomNonConfigurationInstance(){
        Log.d(LOG_TAG, "onRetainCustomNonConfigurationInstance");
        return mContact;
    }

    class Contact {
        String name;
    }
}