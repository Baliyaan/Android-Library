package com.baliyaan.android.mvp.Adapters;

import android.content.Context;

import com.baliyaan.android.mvp.Interfaces.BaseMVPNavigator;

/**
 * Created by Pulkit Singh on 11/5/2017.
 */

public class MVPNavigatorAdapter implements BaseMVPNavigator {

    Context _context = null;

    protected MVPNavigatorAdapter(Context context) {
        _context = context;
    }

    @Override
    public Context getContext() {
        return _context;
    }
}
