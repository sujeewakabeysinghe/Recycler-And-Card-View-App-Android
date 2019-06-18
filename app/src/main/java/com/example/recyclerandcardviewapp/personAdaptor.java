package com.example.recyclerandcardviewapp;

import android.app.ActionBar;
import android.app.Person;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class personAdaptor extends RecyclerView.Adapter<personAdaptor.ViewHolder> {

    private ArrayList<person> people;
    itemClicked activity;

    public interface itemClicked{
        void onItemClicked(int index);
    }

    public personAdaptor(Context context,ArrayList<person> list){
        people=list;
        activity=(itemClicked)context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iv1;
        TextView tv1,tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv1=itemView.findViewById(R.id.iv1);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf((person) v.getTag()));
                }
            });

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.itemView.setTag(people.get(i));
        viewHolder.tv1.setText(people.get(i).getName());
        viewHolder.tv2.setText(people.get(i).getSurname());

        if(people.get(i).getPreference().equals("bus")){
            viewHolder.iv1.setImageResource(R.drawable.bus);
        }
        else{
            viewHolder.iv1.setImageResource(R.drawable.flight);
        }

    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
