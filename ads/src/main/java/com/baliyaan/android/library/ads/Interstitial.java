package com.baliyaan.android.library.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Pulkit on 01-Feb-16.
 */
public class Interstitial extends BaseAd {
    private InterstitialAd mInterstitialAd;
    private Handler mHandler = new Handler();
    private Runnable mRunnable;
    private long mDelayMillis;

    /**
     * @param context
     * @param adUnitID
     */
    public Interstitial(Context context, String adUnitID) {
        super(context);
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(adUnitID);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });
        requestNewInterstitial();
    }

    /*
    * Public services
     */
    public void show() throws Errors.AdException {
        // Check for BuildConfig
        String _BuildConfig = BuildConfig.DEBUG ? "debug" : "release";
        if (_BuildConfig == "debug") {
            if (!_isAllowedInDebug)
                throw new Errors.AdException("DebugMode");
        }

        // Check for installation time
        if (_minTime > 0) {
            if (!HasMinTimePassed())
                throw new Errors.AdException("MinInstallationTImeHasNotPassed");
        }

        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    mInterstitialAd.show();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    // no interstitial available
                    mInterstitialAd = null;
                    Log.d("MyLog", "Ad failed to load");
                }
            });
        }
    }

    public void showEvery(long delayMillis, final boolean showNow) {
        mDelayMillis = delayMillis;
        mRunnable = new Runnable() {
            @Override
            public void run() {
                ((Activity) _context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (showNow == true) {
                            try {
                                show();
                            } catch (Errors.AdException e) {
                                e.printStackTrace();
                            }
                        }
                        mHandler.postDelayed(mRunnable, mDelayMillis);
                    }
                });
            }
        };
        mHandler.post(mRunnable);
    }

    public void stopShowing() {
        mHandler.removeCallbacks(mRunnable);
    }

    /*
    * Private methods
     */
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }
}
