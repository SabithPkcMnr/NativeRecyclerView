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
    int NUMBER_OF_ADS = 4; //TOTAL ADS
    int AD_START_POS = 3; //FIRST AD POSITION (Index number, means List position + 1)
    AdapterList adapterPDFOffline;
    List<Object> modelBase = new ArrayList<>();
    List<UnifiedNativeAd> modelAds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myListRv = findViewById(R.id.recycler_view);
        adapterPDFOffline = new AdapterList(modelBase);

        //Adding Data to List - You could also run a for loop to add X number of items
        modelBase.add(new ModelList("Title One", "Description One"));
        modelBase.add(new ModelList("Title Two", "Description Two"));
        modelBase.add(new ModelList("Title Three", "Description Three"));
        modelBase.add(new ModelList("Title Four", "Description Four"));
        modelBase.add(new ModelList("Title Five", "Description Five"));
        modelBase.add(new ModelList("Title Six", "Description Six"));
        modelBase.add(new ModelList("Title Seven", "Description Seven"));
        modelBase.add(new ModelList("Title Eight", "Description Eight"));
        modelBase.add(new ModelList("Title Nine", "Description Nine"));
        modelBase.add(new ModelList("Title Ten", "Description Ten"));
        modelBase.add(new ModelList("Title Eleven", "Description Eleven"));
        modelBase.add(new ModelList("Title Twelve", "Description Twelve"));
        modelBase.add(new ModelList("Title Thirteen", "Description Thirteen"));
        modelBase.add(new ModelList("Title Fourteen", "Description Fourteen"));
        modelBase.add(new ModelList("Title Fifteen", "Description Fifteen"));

        //myListRv.setHasFixedSize(true);
        myListRv.setNestedScrollingEnabled(false);
        myListRv.setLayoutManager(new LinearLayoutManager(this));
        myListRv.setAdapter(adapterPDFOffline);

        loadNativeAds();
    }

    private void insertAdsInMenuItems() {
        if (modelAds.size() <= 0) {
            return;
        }
        int offset = (modelBase.size() / modelAds.size()) + 1;
        int index = AD_START_POS;
        for (UnifiedNativeAd ad : modelAds) {
            modelBase.add(index, ad);
            index = index + offset;
        }
        adapterPDFOffline.notifyDataSetChanged();
    }

    private void loadNativeAds() {
        AdLoader.Builder builder = new AdLoader.Builder(this, getResources().getString(R.string.admob_native));
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