package com.sabithpkcmnr.nativerecyclerview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sabithpkcmnr.nativerecyclerview.admob.AdMobNativeStyle;

import java.util.ArrayList;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity activity;
    final ArrayList<Object> modelBase;

    public AdapterList(Activity activity, ArrayList<Object> modelBase) {
        this.modelBase = modelBase;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View fbNativeAd = LayoutInflater.from(activity).inflate(R.layout.item_native,
                    parent, false);
            return new HolderMediation(fbNativeAd);
        }
        View menuItemLayoutView = LayoutInflater.from(activity).inflate(R.layout.item_list, parent, false);
        return new MyListHolder(menuItemLayoutView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        if (modelBase.get(position) instanceof ModelAd) {
            ModelAd modelAd = (ModelAd) modelBase.get(position);
            final HolderMediation fbHolder = (HolderMediation) holder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                fbHolder.itemCard.setOutlineAmbientShadowColor(activity.getColor(R.color.colorPrimaryDark));
                fbHolder.itemCard.setOutlineSpotShadowColor(activity.getColor(R.color.colorPrimaryDark));
            }
            if (modelAd.getNativeAd() != null) {
                AdMobNativeStyle styles = new
                        AdMobNativeStyle.Builder().build();
                fbHolder.itemNative.setStyles(styles);
                fbHolder.itemNative.setNativeAd(modelAd.getNativeAd());
            }

        } else {
            MyListHolder menuItemHolder = (MyListHolder) holder;
            ModelList menuItem = (ModelList) modelBase.get(position);
            menuItemHolder.itemTitle.setText(menuItem.getTitle());
            menuItemHolder.itemDescription.setText(menuItem.getDescription());

            menuItemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.startActivity(new Intent(activity, ActivityViewer.class)
                            .putExtra("title", ((ModelList) modelBase.get(position)).getTitle())
                            .putExtra("description", ((ModelList) modelBase.get(position)).getDescription()));
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return modelBase.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (modelBase.get(position) instanceof ModelAd) {
            return 0;
        }
        return 1;
    }

    //ViewHolder for List Data
    public static class MyListHolder extends RecyclerView.ViewHolder {

        private TextView itemTitle, itemDescription;

        MyListHolder(View view) {
            super(view);
            itemTitle = view.findViewById(R.id.itemTitle);
            itemDescription = view.findViewById(R.id.itemDescription);
        }
    }


}