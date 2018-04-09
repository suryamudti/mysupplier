package com.smile.mysupplier.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.smile.mysupplier.App;
import com.smile.mysupplier.R;
import com.smile.mysupplier.adapter.MenuCategoryListAdapter;
import com.smile.mysupplier.api.MenuApi;
import com.smile.mysupplier.model.MenuCategory;
import com.smile.mysupplier.model.response.MenuCategories;
import com.smile.mysupplier.util.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by surymudti on 2/4/18.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_menu_category) RecyclerView menuRecyclerView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    @BindView(R.id.btnBeMySupplier) Button btnBeMySupplier;

    private Retrofit retrofit;
    private List<MenuCategory> menuList;
    private MenuCategoryListAdapter menuListAdapter;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        retrofit = new Retrofit.Builder()
                .baseUrl(App.API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        db = new DatabaseHelper(this);

        menuList = new ArrayList<>();
        menuListAdapter = new MenuCategoryListAdapter(this, menuList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        menuRecyclerView.setLayoutManager(mLayoutManager);
        menuRecyclerView.setNestedScrollingEnabled(false);
        menuRecyclerView.setHasFixedSize(true);
        menuRecyclerView.setHorizontalScrollBarEnabled(true);
        menuRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(15), true));
        menuRecyclerView.setItemAnimator(new DefaultItemAnimator());
        menuRecyclerView.setAdapter(menuListAdapter);

        btnBeMySupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SupplierRegisterActivity.class);
                startActivity(intent);
            }
        });

        getMenus();

    }

    private void getMenus(){
        MenuApi service = retrofit.create(MenuApi.class);

        Call<MenuCategories> call = service.menuCategories();

        call.enqueue(new Callback<MenuCategories>() {
            @Override
            public void onResponse(Call<MenuCategories> call, Response<MenuCategories> response) {
                if (response.raw().isSuccessful()) {

                    menuList.clear();
                    menuList.addAll(response.body().getMenuCategories());
                    menuListAdapter.notifyDataSetChanged();
                }

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<MenuCategories> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }



    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
