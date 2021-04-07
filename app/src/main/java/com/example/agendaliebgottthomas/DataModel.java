package com.example.agendaliebgottthomas;

import java.util.ArrayList;

public class DataModel {
    private static DataModel instance = new DataModel();

    private DataModel(){
    }

    public static DataModel getInstance(){
        return instance;
    }

    public ArrayList<String> ads = new ArrayList<>();

    public int itemSelected = -1;

    public ArrayList<String> getNames(){
        ArrayList<String> arrayList = new ArrayList<>();
        return arrayList;
    }
}
