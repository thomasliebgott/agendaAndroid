package com.example.agendaliebgottthomas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataModel {
    int i=0;
    private static DataModel instance = new DataModel();

    public ArrayList<Contacts> listContact = new ArrayList<>();
    ArrayList<String> itemArray = new ArrayList<>();

    public String getName(int itemSelected){
        return listContact.get(itemSelected).getName();
    }

    public void addContact(String name){
        listContact.add(new Contacts(name,"",""));
    }

    public void setContact(int itemSelected, String name){
        listContact.get(itemSelected).setName(name);
    }

    public String getPhone(int itemSelected){
        return listContact.get(itemSelected).getPhone();
    }

    public String getAdress(int itemSelected){
        return listContact.get(itemSelected).getAdress();
    }

    private DataModel(){
    }

    public static DataModel getInstance(){
        return instance;
    }

    public int itemSelected = -1;

// fonction qui lit les noms des differents contacts (like Activities App)
    public ArrayList<String> getContactNames(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (Contacts contacts:listContact) {
            arrayList.add(contacts.getName());
        }
        return arrayList;
    }

}
