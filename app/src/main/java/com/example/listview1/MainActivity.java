package com.example.listview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] tStory=getResources().getStringArray(R.array.title_story);
        String[] dStory=getResources().getStringArray(R.array.details_story);
        listView=findViewById(R.id.list);
        ArrayList<Dish> arr= new ArrayList<>();
        arr.add(new Dish("ramu","BCE"));
        arr.add(new Dish("rau","BE"));
        arr.add(new Dish("rmu","BC"));
        DishAdapter adapter=new DishAdapter(this,android.R.layout.simple_list_item_1,arr);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t=dStory[position];
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("story",t);
                startActivity(intent);
            }

        });
if ((!isConneted())){
    Toast.makeText(MainActivity.this,"no iternet Access", Toast.LENGTH_LONG).show();
}
else {

    Toast.makeText(MainActivity.this,"internet Access", Toast.LENGTH_LONG).show();
}
    }
private boolean isConneted() {
ConnectivityManager connectivityManager=(ConnectivityManager) getApplicationContext().getSystemService(context.CONNECTIVITY_SERVICE);
return  connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();

}
 }



