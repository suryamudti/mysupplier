package com.smile.mysupplier.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smile.mysupplier.App;
import com.smile.mysupplier.R;
import com.smile.mysupplier.activity.MenuDetailListActivity;
import com.smile.mysupplier.model.MenuCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by surymudti on 2/4/18.
 */

public class MenuCategoryListAdapter extends RecyclerView.Adapter<MenuCategoryListAdapter.MyViewHolder> {

    private Context mContext;
    private List<MenuCategory> menuList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.image);
            name = (TextView) view.findViewById(R.id.name);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    intent = new Intent(mContext, MenuDetailListActivity.class);
                    MenuCategory menuCategory = menuList.get(getAdapterPosition());
                    intent.putExtra("menuCategory", menuCategory);
                    intent.putExtra("hotMenu", false);
                    intent.putExtra("category", getAdapterPosition()+"");
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public MenuCategoryListAdapter(Context mContext, List<MenuCategory> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_menu_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        MenuCategory hotMenu = menuList.get(position);
        holder.name.setText(hotMenu.getName());
        String image = App.URL + "files/menu-categories/list/" + hotMenu.getImage();
        Log.e("hello moto",image);
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
    public void addAll(List<MenuCategory> menuList) {
        menuList.addAll(menuList);
        notifyDataSetChanged();
    }

    public void add(MenuCategory menu) {
        menuList.add(menu);
        notifyDataSetChanged();
    }
}
