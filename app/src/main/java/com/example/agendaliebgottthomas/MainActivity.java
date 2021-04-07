package com.example.agendaliebgottthomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private Contacts contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.mainActivityTitle);
        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToItemEditTextContact(position);
            }
        });
         //supprimer en appuyant longtemps
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                DataModel.getInstance().listContact.remove(position);
                updateContents();
                Toast.makeText(MainActivity.this,"delete",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        updateContents();
    }

    void updateContents(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                DataModel.getInstance().itemArray
        );
        listView.setAdapter(adapter);
    }

    public void buttonAdd(View view){
        goToItemEditTextContact(-1);
    }

    //clic nous envoie vers editText activity
    void goToItemEditTextContact(int index){
        DataModel.getInstance().itemSelected = index;
        Intent intent = new Intent(
                MainActivity.this,
                EditTextContact.class
        );
        startActivity(intent);
    }
}
