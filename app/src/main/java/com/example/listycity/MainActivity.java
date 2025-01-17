package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    int selectedPos = -1;
    EditText inputTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list); //find reference to ListView
        String []cities = {"Edmonton", "Vancouver", "Moscow","Sydney","Berlin","Vienna",
        "Tokyo","Beijing","Osaka","New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        //delete
        https://www.tutorialspoint.com/how-to-handle-the-click-event-in-listview-in-android
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPos = position;
            }
        });

        Button delButton = findViewById(R.id.delete_button);
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedPos!=-1) {
                    dataList.remove(selectedPos);
                    cityAdapter.notifyDataSetChanged();
                    selectedPos = -1;
                }
            }
        });

        //add
        //https://www.geeksforgeeks.org/how-to-dynamically-add-elements-to-a-listview-in-android/
        Button addButton = findViewById(R.id.add_button);
        inputTxt = findViewById(R.id.input);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = inputTxt.getText().toString();
                if(!item.isEmpty()){
                    dataList.add(item);
                    cityAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}





        