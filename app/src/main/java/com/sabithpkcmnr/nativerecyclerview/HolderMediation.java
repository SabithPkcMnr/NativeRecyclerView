package com.sabithpkcmnr.nativerecyclerview;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.sabithpkcmnr.nativerecyclerview.admob.AdMobNativeTemplate;

public class HolderMediation extends RecyclerView.ViewHolder {

    public MaterialCardView itemCard;
    public AdMobNativeTemplate itemNative;

    public HolderMediation(View view) {
        super(view);
        itemCard = view.findViewById(R.id.itemCard);
        itemNative = view.findViewById(R.id.itemNative);
    }
}