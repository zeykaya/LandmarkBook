package com.kaya.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.listView);
        //Data
        ArrayList<String> landmarkNames= new ArrayList<>();
        landmarkNames.add("Pisa");
        landmarkNames.add("Eiffel");
        landmarkNames.add("Colleseo");
        landmarkNames.add("London Bridge");

        ArrayList<String> countryNames= new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");

        Bitmap pisa= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap clessi= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.clessi);
        Bitmap lndn= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.lndn);


        ArrayList<Bitmap>landmarkImage=new ArrayList<>();
        landmarkImage.add(pisa);
        landmarkImage.add(eiffel);
        landmarkImage.add(clessi);
        landmarkImage.add(lndn);

        //ListView
        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {

               // System.out.println(landmarkNames.get(i));
               // System.out.println(countryNames.get(i));
                Intent intent=new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",landmarkNames.get(i));
                intent.putExtra("country",countryNames.get(i));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(landmarkImage.get(i));

                startActivity(intent);

            }
        });


    }
}