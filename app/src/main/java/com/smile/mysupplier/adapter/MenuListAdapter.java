package com.smile.mysupplier.adapter;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.smile.mysupplier.App;
import com.smile.mysupplier.R;
import com.smile.mysupplier.activity.MenuDetailActivity;
import com.smile.mysupplier.activity.MenuDetailListActivity;
import com.smile.mysupplier.model.Menu;
import com.smile.mysupplier.util.DatabaseHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hendrigunawan on 5/31/17.
 */

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MyViewHolder> {

    private MenuDetailListActivity mContext;
    private List<Menu> menuList;

    DatabaseHelper db;
//    SessionManager sessionManager;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image, wishlist, wishlistOutline;
        public TextView name, price;

        public MyViewHolder(View view) {
            super(view);

            db = new DatabaseHelper(mContext);
//            sessionManager = new SessionManager(mContext);

            image = (ImageView) view.findViewById(R.id.image);
            name = (TextView) view.findViewById(R.id.name);
            price = (TextView) view.findViewById(R.id.price);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intentToMenuDetail();
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intentToMenuDetail();
                }
            });
        }

        private void intentToMenuDetail() {
            Intent intent;
            intent = new Intent(mContext, MenuDetailActivity.class);
            Menu menuCategory = menuList.get(getAdapterPosition());
            intent.putExtra("menu", menuCategory);
            mContext.startActivity(intent);
        }
    }

    public MenuListAdapter(MenuDetailListActivity mContext, List<Menu> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Menu menu = menuList.get(position);

        holder.name.setText(menu.getShortName());
        holder.price                                                                                                           .setText(menu.getFormattedPrice());
        String image = App.URL + "files/menu-images/" + menu.getImage();
        Picasso.with(mContext).load(image).error(R.drawable.image_315x315).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        menuList.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Menu> menuList) {
        menuList.addAll(menuList);
        notifyDataSetChanged();
    }

    public void add(Menu menu) {
        menuList.add(menu);
        notifyDataSetChanged();
    }
}
