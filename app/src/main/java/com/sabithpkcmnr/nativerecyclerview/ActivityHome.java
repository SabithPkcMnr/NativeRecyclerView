package com.sabithpkcmnr.nativerecyclerview;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;

import java.util.ArrayList;

public class ActivityHome extends AppCompatActivity {

    int adPos;
    int adTotalCount = 0;
    boolean isSecondCase;
    int adCurrentPosition = 0;
    ArrayList<Object> modelBookList = new ArrayList<>();
    ArrayList<Integer> adPositionList = new ArrayList<>();

    RecyclerView itemList;
    AdapterList adapterPDFOffline;
    ArrayList<Object> modelBase = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setIcon(R.drawable.ic_home);

        itemList = findViewById(R.id.itemList);
        adapterPDFOffline = new AdapterList(ActivityHome.this, modelBookList);

        for (int a = 1; a <= 15; a++) {
            modelBookList.add(new ModelList("Title " + a, "Description " + a));
            if (adPos % 5 == 2) {
                modelBookList.add(new ModelAd());
                adPositionList.add(modelBookList.size() - 1);
                adTotalCount++;
            }
            adPos++;
        }

        itemList.setHasFixedSize(true);
        itemList.setNestedScrollingEnabled(false);
        itemList.setLayoutManager(new LinearLayoutManager(this));
        itemList.setAdapter(adapterPDFOffline);

        loadNativeAds();
    }

    private void loadNativeAds() {
        AdLoader adLoader = new AdLoader.Builder(this, getResources().getString(R.string.admob_native))
                .forNativeAd(new com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(com.google.android.gms.ads.nativead.NativeAd nativeAd) {
                        Log.d("logAdapterCoin", "Native Ad Loaded A");

                        if (isDestroyed()) {
                            nativeAd.destroy();
                        }

                        try {
                            int adListPosition = adPositionList.get(adCurrentPosition);
                            /*if (isSecondCase) {
                                adListPosition = adListPosition + additionValue;
                                additionValue++;
                            }*/
                            modelBookList.set(adListPosition, new ModelAd(nativeAd));
                            adapterPDFOffline.notifyItemChanged(adListPosition);
                            adCurrentPosition++;
                            isSecondCase = true;
                            loadNativeAds();

                        } catch (IndexOutOfBoundsException ignored) {
                        }
                    }
                }).withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        Log.d("logAdapterCoin", "Native Ad Failed A - " + loadAdError.getMessage());
                        Log.d("logAdapterCoin", "Native Ad Failed B - " + loadAdError.getResponseInfo());
                        super.onAdFailedToLoad(loadAdError);
                    }

                    @Override
                    public void onAdLoaded() {
                        Log.d("logAdapterCoin", "Native Ad Loaded");
                        super.onAdLoaded();
                    }
                })
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

}