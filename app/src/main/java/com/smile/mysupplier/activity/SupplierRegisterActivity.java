package com.smile.mysupplier.activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AutoCompleteTextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.smile.mysupplier.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SupplierRegisterActivity extends AppCompatActivity  {

    @BindView(R.id.agree) AppCompatButton btnAgree;
    @BindView(R.id.email) AutoCompleteTextView etEmail;
    @BindView(R.id.nomorTelepon) AutoCompleteTextView etNomorTelepon;
    @BindView(R.id.nomorHP) AutoCompleteTextView etNomorHP;
    @BindView(R.id.nomorKtp) AutoCompleteTextView etNomorKTP;
    @BindView(R.id.nomorKK) AutoCompleteTextView etNomorKK;
    @BindView(R.id.namaLengkap) AutoCompleteTextView etNamaLengkap;



    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_register);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupplierRegisterActivity.this,LocationRegisterActivity.class);
                startActivity(intent);
            }
        });

    }


}
