package com.google.firebase.example.fireeats.util;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by adnanali on 01/03/2017.
 */

public class JsonReadUtils {
    public static String loadJSONFromAsset(Context context, String fileName) {
        String json;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
            Log.d("JSON READ", "loadJSONFromAsset: " + json);
        } catch (IOException ex) {
            return null;
        }
        return json;
    }


    public static List<String> getKeys(JSONObject jsonObject) {
        List<String> keysList = new ArrayList<>();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            keysList.add(keys.next());
        }
        return keysList;
    }

    public static ArrayList<String> getList(JSONArray jsonArray) {
        ArrayList<String> keysList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                keysList.add(jsonArray.getString(i));
            } catch (JSONException ex) {

            }
        }
        return keysList;
    }
}
