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
        int itemSelected = DataModel.getInstance().itemSelected;
        if(itemSelected >=0){
            String name = DataModel.getInstance().getName(itemSelected);
            editName.setText(name);
        }else{
            editName.setText("");
        }
    }

    @Override
    public void onBackPressed() {
        String item = editName.getText().toString();
        if(item.length() > 0){
            int itemSelected = DataModel.getInstance().itemSelected;
            if(itemSelected < 0){
                DataModel.getInstance().addContact(item); // PB doit ajouter l'objet du contact
            }else{
                DataModel.getInstance().setContact(itemSelected,item); //
            }
        }
        finish();
    }
}
