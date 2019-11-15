package com.svafvel.software.production.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private String[] dataName = {"Cut Nyak Dien", "Ki Hajar Dewantara", "Moh Yasin", "Patimura","R A Kartini", "Sukarno"};

    private HeroAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;

    private ArrayList<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ListView listview = findViewById(R.id.lv_list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
//
//        listview.setAdapter(adapter);

        ListView listview = findViewById(R.id.lv_list);
        adapter = new HeroAdapter(this);
        listview.setAdapter(adapter);

        prepare();
        addItem();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void prepare(){

        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

    }

    private void addItem(){

        heroes = new ArrayList<>();

        for(int i = 0; i < dataName.length; i++){

            Hero hero = new Hero();
            hero.setPhoto((dataPhoto.getResourceId(i, 1)));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);

        }

        adapter.setHeroes(heroes);

    }

}
