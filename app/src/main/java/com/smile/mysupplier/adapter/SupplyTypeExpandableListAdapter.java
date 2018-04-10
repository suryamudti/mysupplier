package com.smile.mysupplier.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cranium.sushiteiapps.App;
import com.cranium.sushiteiapps.R;
import com.cranium.sushiteiapps.activity.VoucherDetailActivity;
import com.cranium.sushiteiapps.api.MessageApi;
import com.cranium.sushiteiapps.model.Message;
import com.cranium.sushiteiapps.model.response.MessageUpdated;
import com.cranium.sushiteiapps.util.SessionManager;
import com.smile.mysupplier.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hendrigunawan on 06/16/17.
 */

public class SupplyTypeExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Message> messageList; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public SupplyTypeExpandableListAdapter(Context context, List<Message> listDataHeader,
                                           HashMap<String, List<String>> listChildData) {
        this.context = context;
        this.messageList = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(String.valueOf(this.messageList.get(groupPosition).getId())).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);
//        final Message message = (Message) messageList.get(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.voucher_detail, null);
        }

        TextView description = (TextView) convertView.findViewById(R.id.description);
        TextView readMore = (TextView) convertView.findViewById(R.id.readmore);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);

        description.setText(message.getShortDescription());
//        Picasso.with(context).load(App.URL + "files/messages/" + message.getImage()).error(R.drawable.image_315x315).into(image);


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(String.valueOf(this.messageList.get(groupPosition).getId()))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.messageList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.messageList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View view, ViewGroup parent) {
//        final Message message = (Message) messageList.get(groupPosition);
//        int accent = context.getResources().getColor(R.color.colorAccent);
//        int white = context.getResources().getColor(R.color.colorWhite);
//        int dark = context.getResources().getColor(R.color.colorDark);
//        final Drawable messageOpenedDark = ContextCompat.getDrawable(context, R.drawable.ic_message_open_outline_24_dp);
//        final Drawable messageOpenedWhite = ContextCompat.getDrawable(context, R.drawable.ic_message_open_white_outline_24_dp);
//        final Drawable messageUnRead = ContextCompat.getDrawable(context, R.drawable.ic_message_green_outline_24_dp);
//
//        if (view == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this.context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = infalInflater.inflate(R.layout.voucher_list, null);
//        }
//
//        TextView name = (TextView) view.findViewById(R.id.name);
//        TextView date = (TextView) view.findViewById(R.id.date);
//        ImageView messageImage = (ImageView) view.findViewById(R.id.message_image);
//
//        if (isExpanded) {
//            view.setBackgroundResource(R.color.colorAccent);
//            name.setTextColor(white);
//            date.setTextColor(white);
//            messageImage.setImageDrawable(messageOpenedWhite);
//            if (message.getReadAt() == null) {
//                message.setReadAt((new Date()).toString());
//                setToUpdated(message);
//            }
//        } else {
//            view.setBackgroundResource(R.color.colorWhite);
//
//            if (message.getReadAt() != null) {
//                name.setTextColor(dark);
//                date.setTextColor(dark);
//                messageImage.setImageDrawable(messageOpenedDark);
//            } else {
//                name.setTextColor(accent);
//                date.setTextColor(accent);
//                messageImage.setImageDrawable(messageUnRead);
//            }
//        }
//
//        name.setText(message.getShortName());
//        date.setText(message.getShortStartDate());

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
