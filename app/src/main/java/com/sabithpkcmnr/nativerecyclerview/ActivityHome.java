package com.sabithpkcmnr.nativerecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

import java.util.ArrayList;
import java.util.List;

public class ActivityHome extends AppCompatActivity {

    AdLoader adLoader;
    RecyclerView myListRv;
    int NUMBER_OF_ADS = 4;
    AdapterList adapterPDFOffline;
    List<Object> modelBase = new ArrayList<>();
    List<UnifiedNativeAd> modelAds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myListRv = findViewById(R.id.recycler_view);
        myListRv.setLayoutManager(new LinearLayoutManager(this));

        for (int a = 0; a < 30; a++) {
            modelBase.add(new ModelBase("Item: " + a));
        }

        adapterPDFOffline = new AdapterList(modelBase);

        myListRv.setHasFixedSize(true);

        myListRv.setNestedScrollingEnabled(false);

        myListRv.setAdapter(adapterPDFOffline);

        loadNativeAds();
    }

    private void insertAdsInMenuItems() {
        if (modelAds.size() <= 0) {
            return;
        }
        int offset = (modelBase.size() / modelAds.size()) + 1;
        int index = 4;
        for (UnifiedNativeAd ad : modelAds) {
            modelBase.add(index, ad);
            index = index + offset;
        }
        adapterPDFOffline.notifyDataSetChanged();
    }

    private void loadNativeAds() {
        AdLoader.Builder builder = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/8135179316");
        adLoader = builder.forUnifiedNativeAd(
                new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        modelAds.add(unifiedNativeAd);
                        if (!adLoader.isLoading()) {
                            insertAdsInMenuItems();
                        }
                    }
                }).withAdListener(
                new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        if (!adLoader.isLoading()) {
                            insertAdsInMenuItems();
                        }
                    }
                }).build();
        adLoader.loadAds(new AdRequest.Builder().build(), NUMBER_OF_ADS);
    }

}