package com.example.agendaliebgottthomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditTextContact extends AppCompatActivity {

    EditText editName;
    EditText editPhone;
    EditText editAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        editAdress = findViewById(R.id.editAdress);
    }

    @Override
    protected void  onResume(){
        super.onResume();
        int itemSelected = DataModel.getInstance().itemSelected; //prend l'index de la list view
        if(itemSelected >=0){
            Contacts aux = DataModel.getInstance().listContact.get(itemSelected);
            editName.setText(aux.getName());
            editAdress.setText(aux.getAdress());
            editPhone.setText(aux.getPhone());
        }else{
            editName.setText("");
            editAdress.setText("");
            editPhone.setText("");
        }
    }

    @Override
    public void onBackPressed() {
        String name = editName.getText().toString();
        String adress = editAdress.getText().toString();
        String phone = editPhone.getText().toString();
        if(name.length() > 0){
            int itemSelected = DataModel.getInstance().itemSelected;
            if(itemSelected < 0){
                DataModel.getInstance().listContact.add(new Contacts(name,adress,phone));// PB doit ajouter l'objet du contact
            }else{
                DataModel.getInstance().listContact.get(itemSelected).setName(name);
                DataModel.getInstance().listContact.get(itemSelected).setAdress(adress);
                DataModel.getInstance().listContact.get(itemSelected).setPhone(phone);
            }
        }
        finish();
    }
}
