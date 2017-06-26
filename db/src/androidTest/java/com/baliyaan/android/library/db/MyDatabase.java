package com.baliyaan.android.library.db;

import android.content.Context;

import com.baliyaan.android.library.db.SQLiteAssetHelper.SQLiteAssetHelper;

/**
 * Created by Pulkit Singh on 6/26/2017.
 */

public class MyDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "WordsList.db";
    private static final int DATABASE_VERSION = 2;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }
}
