package com.example.dhrubo.learnpaths;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.app.SearchManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "StateMessage";
    private EditText searchFor_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");


        Button pro_btn = (Button) findViewById(R.id.pro_btn);
        pro_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        progActivity();
                    }
                }
        );

        searchFor_id = (EditText) findViewById(R.id.searchFor_id);
        Button search_btn = (Button) findViewById(R.id.search_btn);
        search_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        onSearchClick();
                    }
                }
        );

        Button gen_btn = (Button) findViewById(R.id.gen_btn);
        gen_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        genActivity();
                    }
                }
        );

        Button phy_btn = (Button) findViewById(R.id.phy_btn);
        phy_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        physActivity();
                    }
                }
        );

        Button chem_btn = (Button) findViewById(R.id.chem_btn);
        chem_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        chemActivity();
                    }
                }
        );

        Button maths_btn = (Button) findViewById(R.id.maths_btn);
        maths_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        mathsActivity();
                    }
                }
        );

        Button per_btn = (Button) findViewById(R.id.per_btn);
        per_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        perActivity();
                    }
                }
        );
    }

    public void onSearchClick()
    {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        String search = searchFor_id.getText().toString();
        if(search.equals("")){
            search = "how old is the earth";
        }
        intent.putExtra(SearchManager.QUERY, search);
        startActivity(intent);
    }


    private void progActivity() {
        Intent intent = new Intent(this, progActivity.class);
        startActivity(intent);
    }

    private void physActivity() {
        Intent intent = new Intent(this, PhysicsActivity.class);
        startActivity(intent);
    }

    private void chemActivity() {
        Intent intent = new Intent(this, ChemistryActivity.class);
        startActivity(intent);
    }

    private void genActivity() {
        Intent intent = new Intent(this, General.class);
        startActivity(intent);
    }

    private void mathsActivity() {
        Intent intent = new Intent(this, MathsActivity.class);
        startActivity(intent);
    }

    private void perActivity() {
        Intent intent = new Intent(this, PersonalizedActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }
}
