package com.baliyaan.android.mvp.Interfaces;

import android.os.Bundle;

/**
 * Created by Pulkit Singh on 7/2/2017.
 */

public interface BaseMVPPort {
    void onSaveState(Bundle state);
    void onRestoreState(Bundle state);
}
