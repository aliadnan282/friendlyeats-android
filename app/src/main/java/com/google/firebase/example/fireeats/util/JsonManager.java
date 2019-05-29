package com.google.firebase.example.fireeats.util;

import android.content.Context;
import android.util.Log;

import com.google.firebase.example.fireeats.model.PlanModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class JsonManager {
    public static JsonManager ourInstance;
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();
    Context context;

    private JsonManager(Context context) {
        this.context=context;
    }

    public static JsonManager getInstance(Context context) {
        if (ourInstance == null)
            ourInstance = new JsonManager(context);

        return ourInstance;
    }


    public PlanModel getPlanExercise() {
        String exerciseJson = JsonReadUtils.loadJSONFromAsset(context,"workout_json/plan.json");
        return gson.fromJson(exerciseJson, PlanModel.class);
    }

}