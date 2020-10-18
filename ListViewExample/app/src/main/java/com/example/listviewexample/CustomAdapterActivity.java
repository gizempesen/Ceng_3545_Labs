package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterActivity extends AppCompatActivity {

    final List<Animal> animals = new ArrayList<Animal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        animals.add(new Animal("Ant", R.mipmap.ic_butterfly));
        animals.add(new Animal("Bear", R.mipmap.ic_butterfly));
        animals.add(new Animal("Butterfly", R.mipmap.ic_butterfly));
        animals.add(new Animal("Cat", R.mipmap.ic_cat));
        animals.add(new Animal("Dog", R.mipmap.ic_cat));

        final ListView listView = findViewById(R.id.listview);
        AnimalAdapter adapter = new AnimalAdapter(animals, this);

        listView.setAdapter(adapter);

    }
}