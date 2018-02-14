package com.example.lenovo.expendablelistviewwithrecyleview;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by lenovo on 13/02/2018.
 */

public class TestExpend extends BaseExpandableListAdapter {

    private List<String> headerTitles;
    private HashMap<String,List<String>> childValues;
    private Context context;

    public TestExpend(List<String> headerTitles, HashMap<String, List<String>> childValues, Context context) {
        this.headerTitles = headerTitles;
        this.childValues = childValues;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return headerTitles.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childValues.get(headerTitles.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return headerTitles.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childValues.get(headerTitles.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String header = (String) this.getGroup(i);

//        View mView = view;
        if(view == null){
            view  = LayoutInflater.from(context).inflate(R.layout.group_view,viewGroup,false);
        }

//        ExpandableListView ExplistView =(ExpandableListView) view.findViewById(R.id.expendable_listview);

        TextView textView = (TextView) view.findViewById(R.id.expendview_header);
        textView.setText(header);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String child = (String) this.getChild(i,i1);

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.child_view,viewGroup,false);
        }

        RecyclerView recyclerView = view.findViewById(R.id.expend_child_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,
                false));

//        List list = new ArrayList();
//        list.add("first");
//        list.add("2nd");
//        list.add("3rd");
//        list.add("4th");
//        list.add("5th");
//        list.add("6th");
        MenuItemAdapter menuItemAdapter = new MenuItemAdapter(childValues.get(headerTitles.get(i)),context);

//        SnapHelper snapHelper = new LinearSnapHelper();
//        recyclerView.setOnFlingListener(null);
//        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(menuItemAdapter);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
