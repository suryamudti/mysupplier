package com.smile.mysupplier.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smile.mysupplier.R;

public class QuantityRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
