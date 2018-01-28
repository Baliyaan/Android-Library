package com.baliyaan.android.library.io;

import android.content.Context;

import java.io.*;
import java.io.File;

/**
 * Created by Pulkit Singh on 1/28/2018.
 */

public class SerializeService {
    public static Object deserialize(Context context, String filename) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new java.io.File(context.getFilesDir(), "") + java.io.File.separator + filename));
            return in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void serialize(Object object, Context context, String filename) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new java.io.File(context.getFilesDir(), "") + File.separator + filename));
            out.writeObject(object);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
