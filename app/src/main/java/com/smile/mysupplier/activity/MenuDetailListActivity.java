package com.smile.mysupplier.activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.smile.mysupplier.App;
import com.smile.mysupplier.R;
import com.smile.mysupplier.adapter.MenuListAdapter;
import com.smile.mysupplier.api.MenuApi;
import com.smile.mysupplier.model.Menu;
import com.smile.mysupplier.model.MenuCategory;
import com.smile.mysupplier.model.response.HotMenusByCategory;
import com.smile.mysupplier.util.DatabaseHelper;
import com.squareup.picasso.Picasso;

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

public class MenuDetailListActivity extends AppCompatActivity {

    private MenuCategory menuCategory;
    private MenuListAdapter menuListAdapter;
    private List<Menu> menuList;

    @BindView(R.id.image) ImageView imageView;
    @BindView(R.id.menu_recycler_view) RecyclerView menuRecyclerView;
    @BindView(R.id.search_edit) EditText searchEdit;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    @BindView(R.id.swipeContainer) SwipeRefreshLayout swipeContainer;

    private DatabaseHelper db;

    public Retrofit retrofit;
    public Integer selectedWishlist;
    public boolean isHotMenu;
    public String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail_list);
        ButterKnife.bind(this);
        db = new DatabaseHelper(getBaseContext().getApplicationContext());

        menuCategory = (MenuCategory) getIntent().getSerializableExtra("menuCategory");
        isHotMenu = getIntent().getBooleanExtra("hotMenu", false);
        category = getIntent().getStringExtra("category");
        String image = App.URL + "files/menu-categories/detail/" + menuCategory.getImage();
        Picasso.with(this).load(image).error(R.drawable.image_315x315).into(imageView);

        retrofit = new Retrofit.Builder()
                .baseUrl(App.API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        menuList = new ArrayList<>();
        menuListAdapter = new MenuListAdapter(this, menuList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        menuRecyclerView.setLayoutManager(mLayoutManager);
        menuRecyclerView.setNestedScrollingEnabled(false);
        menuRecyclerView.setHasFixedSize(true);
        menuRecyclerView.setHorizontalScrollBarEnabled(true);
        menuRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(15), true));
        menuRecyclerView.setItemAnimator(new DefaultItemAnimator());
        menuRecyclerView.setAdapter(menuListAdapter);

        getMenus();

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

    private void getMenus(){
        MenuApi service = retrofit.create(MenuApi.class);

        Call<HotMenusByCategory> call = service.menusByCategory(menuCategory.getId(), searchEdit.getText().toString());
        if(isHotMenu) {
            call = service.hotMenusByCategory(menuCategory.getId(), searchEdit.getText().toString());
        }

        call.enqueue(new Callback<HotMenusByCategory>() {
            @Override
            public void onResponse(Call<HotMenusByCategory> call, Response<HotMenusByCategory> response) {

                if (response.raw().isSuccessful()) {
                    swipeContainer.setRefreshing(false);
                    menuList.clear();
                    menuList.addAll(response.body().getMenus());

                    menuListAdapter.notifyDataSetChanged();
                    Log.e("categori",category);
                    db.createHotMenuDetails(response.body(),category);

                } else {
                    Toast.makeText(getApplicationContext(), "Menu is not found", Toast.LENGTH_LONG).show();
                }

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<HotMenusByCategory> call, Throwable t) {

            }
        });
    }


    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
