package com.example.agendaliebgottthomas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataModel {
    int i=0;
    private static DataModel instance = new DataModel();

//    ArrayList<Contacts> listContact = new ArrayList<>();

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

//    public void getPhone(int itemSelected){
//        listContact.get(itemSelected).getPhone();
//    }
//
//    public void getAdress(int itemSelected){
//        listContact.get(itemSelected).getAdress();
//    }
//
//    public void removeContact(int itemSelected){
//        listContact.remove(itemSelected);
//    }

    private DataModel(){
    }

    public static DataModel getInstance(){
        return instance;
    }

    public int itemSelected = -1;
//
//    public ArrayList<String> getName(){
//        ArrayList<String> arrayList = new ArrayList<>();
//        return arrayList;
//    }

// fonction qui lit les noms des differents contacts (like Activities App)
    public ArrayList<String> getContactNames(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (Contacts contacts:listContact) {
            arrayList.add(contacts.getName());
        }
        return arrayList;
    }

}
