package com.example.mike.materialdesignlistviewpopup;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> names;
    ArrayAdapter<String> adapter;
    RecyclerView.Adapter<CardViewRecyclerViewAdapter.CardViewHolder> cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = new ArrayList<String>();

        names.add("Bob");
        names.add("Joe");
        names.add("Fronk");
        names.add("Mary");
        names.add("Jules");
        names.add("Shaina");
        names.add("Andy");
        names.add("Joanna");

        CardViewRecyclerViewAdapter adapter = new CardViewRecyclerViewAdapter(getApplicationContext(), names);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

//        adapter = new PopUpArrayAdapter(this, R.id.activity_main, R.id.pop_up_list_view, names);
//
//        ListView listView = (ListView) findViewById(R.id.pop_up_list_view);
//
//        listView.setAdapter(adapter);

    }
}
