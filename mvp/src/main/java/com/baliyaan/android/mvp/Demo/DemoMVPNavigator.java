package com.baliyaan.android.mvp.Demo;

import android.app.Activity;

import com.baliyaan.android.mvp.Adapters.MVPNavigatorAdapter;

/**
 * Created by Pulkit Singh on 11/4/2017.
 */

public class DemoMVPNavigator extends MVPNavigatorAdapter
        implements DemoMVPContract.Navigator {

    private DemoMVPContract.Port _port = null;

    DemoMVPNavigator(Activity activity){
        super(activity);

        _port = new DemoMVPViewPort((Activity) getContext(),this);
        _port.makePortSomething();
    }

    public void makeNavigatorSomething() {
    }
}
