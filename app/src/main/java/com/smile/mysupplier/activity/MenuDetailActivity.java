package com.smile.mysupplier.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.smile.mysupplier.App;
import com.smile.mysupplier.R;
import com.smile.mysupplier.model.Menu;
import com.smile.mysupplier.util.DatabaseHelper;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;

public class MenuDetailActivity extends AppCompatActivity {


    @BindView(R.id.image) ImageView image;
    @BindView(R.id.name) TextView name;
    @BindView(R.id.description) TextView description;
    @BindView(R.id.price) TextView price;


    private Menu menu;
    public Retrofit retrofit;
    private DatabaseHelper db;
    public Integer selectedWishlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = new DatabaseHelper(MenuDetailActivity.this);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build();
                return chain.proceed(newRequest);
            }
        }).readTimeout(App.TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(App.TIMEOUT, TimeUnit.SECONDS).build();

        menu = (Menu) getIntent().getSerializableExtra("menu");

        setTitle(menu.getShortName());

        Picasso.with(this).load(App.URL + "files/menu-images/" + menu.getImage()).into(image);

        name.setText(menu.getName());
        description.setText(menu.getDescription());
        price.setText(menu.getFormattedPrice());
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
