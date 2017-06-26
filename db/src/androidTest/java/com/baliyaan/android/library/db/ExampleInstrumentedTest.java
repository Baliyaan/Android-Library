package com.baliyaan.android.library.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        //assertEquals("com.baliyaan.android.library.db.test", appContext.getPackageName());
        SQLiteDatabase db = new MyDatabase(appContext).getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from WordsList;",null);
        //Traverse cursor
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndex("word"));
                Log.i("SQLiteAssetHelperTest",word);
            } while (cursor.moveToNext());
        }

        cursor.close();
    }
}
