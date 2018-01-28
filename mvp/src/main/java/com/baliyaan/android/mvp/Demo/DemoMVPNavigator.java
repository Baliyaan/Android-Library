package com.baliyaan.android.mvp.Demo;

import android.app.Activity;
import android.os.Bundle;

import com.baliyaan.android.mvp.Adapters.MVPNavigatorAdapter;

/**
 * Created by Pulkit Singh on 11/4/2017.
 */

public class DemoMVPNavigator extends MVPNavigatorAdapter
        implements DemoMVPContract.Navigator {

    private DemoMVPContract.Port _port = null;

    @Override
    public Object getInstanceOf(String className, Bundle params) {
        return super.getInstanceOf(className, params);
    }

    DemoMVPNavigator(Activity activity){
        super(activity);

        _port = new DemoMVPViewPort(this,null /*...findViewById(...)*/);
        _port.makePortSomething();
    }

    public void makeNavigatorSomething() {
    }
}
