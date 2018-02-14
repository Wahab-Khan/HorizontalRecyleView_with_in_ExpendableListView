package com.example.lenovo.expendablelistviewwithrecyleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 13/02/2018.
 */

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuViewHolder> {

    List<String> listitem;
    Context context;

    public MenuItemAdapter(List<String> listitem, Context context) {
        this.listitem = listitem;
        this.context = context;
    }

   public class MenuViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

       public MenuViewHolder(View itemView) {
           super(itemView);
           textView = itemView.findViewById(R.id.child_text_view);
       }
   }
    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.expendalbe_childview_recyleview_item,
                parent,false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.textView.setText(listitem.get(position));
    }


    @Override
    public int getItemCount() {
        return listitem.size();
    }
}
