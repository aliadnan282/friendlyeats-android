package com.google.firebase.example.fireeats.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    @SerializedName("day")
    private List<Day> day = new ArrayList<>();
    @SerializedName("planId")
    int planId;

    public int getPlanId() {
        return planId;
    }



    public List<Day> getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "ClassPojo [day = " + day + "]";
    }
}