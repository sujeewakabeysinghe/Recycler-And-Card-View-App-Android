package com.example.recyclerandcardviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements personAdaptor.itemClicked {

    RecyclerView rv1;
    RecyclerView.Adapter myAdaptor;
    RecyclerView.LayoutManager layoutManager;
    Button b1;

    ArrayList<person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1=findViewById(R.id.rv1);
        rv1.setHasFixedSize(true);
        b1=findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new person("sathsara","fernando","flight"));
                myAdaptor.notifyDataSetChanged();
            }
        });

        //layoutManager = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        layoutManager = new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);
        rv1.setLayoutManager(layoutManager);

        people = new ArrayList<person>();
        people.add(new person("sujeewa","abeysinghe","bus"));
        people.add(new person("hiruni","alwis","flight"));
        people.add(new person("sujeewa","abeysinghe","bus"));
        people.add(new person("sujeewa","abeysinghe","bus"));
        people.add(new person("sujeewa","abeysinghe","bus"));
        people.add(new person("hiruni","alwis","flight"));
        people.add(new person("sujeewa","abeysinghe","bus"));
        people.add(new person("hiruni","alwis","flight"));
        people.add(new person("sujeewa","abeysinghe","bus"));
        people.add(new person("hiruni","alwis","flight"));

        myAdaptor=new personAdaptor(this,people);
        rv1.setAdapter(myAdaptor);


    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this,"Surename : "+people.get(index).getSurname(),Toast.LENGTH_SHORT).show();
    }
}
