package com.sabithpkcmnr.nativerecyclerview;

import com.google.android.gms.ads.nativead.NativeAd;

public class ModelAd {

    NativeAd nativeAd;

    public ModelAd() {
    }

    public ModelAd(NativeAd nativeAd) {
        this.nativeAd = nativeAd;
    }

    public NativeAd getNativeAd() {
        return nativeAd;
    }
}
