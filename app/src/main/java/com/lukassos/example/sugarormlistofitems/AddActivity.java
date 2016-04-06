package com.lukassos.example.sugarormlistofitems;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lukassos.example.sugarormlistofitems.dummy.DummyContent;

public class AddActivity extends AppCompatActivity {

    private EditText name;
    private EditText lastname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDatabase();
            }
        });
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fabDel);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFromDatabase();
            }

        });
    }

    private void addToDatabase() {
        DummyContent.DummyItem item = new DummyContent.DummyItem(
                name.getText().toString(),
                lastname.getText().toString()
        );
        item.save();
    }

    private void deleteFromDatabase() {
        DummyContent.DummyItem item = new DummyContent.DummyItem(
                name.getText().toString(),
                lastname.getText().toString()
        );
        item.delete();

    }


}
