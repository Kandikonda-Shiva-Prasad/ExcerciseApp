package uk.ac.tees.aad.w9527290.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import uk.ac.tees.aad.w9527290.Models.FirstChellange;
import uk.ac.tees.aad.w9527290.R;
import uk.ac.tees.aad.w9527290.adapter.Five_day_Chellenge_Adapter;

public class Goal_5day extends AppCompatActivity {

    RecyclerView recyclerView;
    Five_day_Chellenge_Adapter adapter;
    ArrayList<FirstChellange> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal5day);
        arrayList = new ArrayList<>();

        arrayList.add(new FirstChellange(R.drawable.one,"Day1"));
        arrayList.add(new FirstChellange(R.drawable.two,"Day2"));
        arrayList.add(new FirstChellange(R.drawable.three,"Day3"));
        arrayList.add(new FirstChellange(R.drawable.four,"Day4"));
        arrayList.add(new FirstChellange(R.drawable.fivees,"Day5"));

        adapter = new Five_day_Chellenge_Adapter(arrayList,Goal_5day.this);

        recyclerView = findViewById(R.id.rec1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }
}