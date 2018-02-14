package com.example.lenovo.expendablelistviewwithrecyleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expendable_listview);
        List<String> headings = new ArrayList<>();
        headings.add("First heading");
        headings.add("Seacound heading");
        headings.add("third");


        List<String> list1 = new ArrayList<>();
        list1.add("1 1 ");
        list1.add("1 2");
        list1.add("1 3");

        List<String> list2 = new ArrayList<>();
        list2.add("2 1 ");
        list2.add("2 2");

        List<String> list3 = new ArrayList<>();
        list3.add("3,1");

        HashMap<String, List<String>> childLists = new HashMap<>();
        childLists.put(headings.get(0),list1);
        childLists.put(headings.get(1),list2);
        childLists.put(headings.get(2),list3);

//        TestExpend testExpend = new TestExpend(headings,childLists,this);
        TestExpend testExpend = new TestExpend(headings,childLists,this);
        expandableListView.setAdapter(testExpend);


    }
}
