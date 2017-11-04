package com.baliyaan.android.library.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.io.File;

import static android.provider.ContactsContract.Directory.PACKAGE_NAME;

/**
 * Created by Pulkit Singh on 11/4/2017.
 */

public class BaseAd {

    Context _context;
    public boolean _isAllowedInDebug = true;
    long _minTime = 0;

    BaseAd(Context context){
        _context = context;
    }

    /**
     * @param allowInDebug
     */
    public void AllowInDebug(boolean allowInDebug){
        _isAllowedInDebug = allowInDebug;
    }

    public void AllowOnlyAfter(long time){
        _minTime = time;
    }

    /*
    * Local methods
     */
    protected boolean HasMinTimePassed(){
        PackageManager pm = _context.getPackageManager();
        ApplicationInfo appInfo = null;
        try {
            appInfo = pm.getApplicationInfo(PACKAGE_NAME, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (null != appInfo) {
            String appFile = appInfo.sourceDir;
            long installed = new File(appFile).lastModified(); //Epoch Time
            long now = System.currentTimeMillis();
            if (now - installed > _minTime) // 3.6e+5 = 6 minutes
                return true;
        }
        return false;
    }
}
