package com.example.reddyz.listviewexample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] foods = {
                "Idly", "Vada",
                "Masala Dosa","Set Dosa","Ghee Dosa",
                "Upma", "Pongal", "Puri","KesariBath",
                "BisibeleBath", "RiceBath", "VangiBath",
                "Ragi Rotti","Akki Rotti","Jolad Rotti",
                "Puliyogare", "Chitranna"
        };

        Integer[] foodResIdList = {
                R.drawable.idly, R.drawable.vada,
                R.drawable.masaladosa, R.drawable.setdosa, R.drawable.gheedosa,
                R.drawable.upma, R.drawable.pongal, R.drawable.puri, R.drawable.kesaribath,
                R.drawable.bisibelebath, R.drawable.ricebath, R.drawable.vangibath,
                R.drawable.ragirotti, R.drawable.akkirotti, R.drawable.joladrotti,
                R.drawable.puliyogare, R.drawable.chitranna
        };

        //Extract The Resource Ids of the images dynamically from Drawable Folder...
        // Name of picture same as the item:)
        /*
        Integer [] foodDynResIdList = new Integer[foods.length];
        String packageName = getPackageName();
        String resourceType = "drawable";
        for(int x=0;x<foods.length; x++) {
            //resource name is small letters and no space/special chars
            String resString = foods[x].toLowerCase().replaceAll("\\s","");
            foodDynResIdList[x]=getResources().getIdentifier(resString,resourceType, packageName);
        }
        ListAdapter myAdapter = new CustomAdapter(this,foods, foodDynResIdList);
        */

        //ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        ListAdapter myAdapter = new CustomAdapter(this, foods, foodResIdList);

        final ListView myListView = (ListView)findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);
        myListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        myListView.setSelector(android.R.color.holo_blue_bright);

        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //view.setBackgroundColor(Color.RED);
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, food+" :$25", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
