package uk.ac.tees.aad.w9527290.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import uk.ac.tees.aad.w9527290.Models.FirstChellange;
import uk.ac.tees.aad.w9527290.Models.SecondChellange;
import uk.ac.tees.aad.w9527290.R;
import uk.ac.tees.aad.w9527290.adapter.Five_day_Chellenge_Adapter;
import uk.ac.tees.aad.w9527290.adapter.Ten_day_Chellenge_Adapter;

public class Goal_10day extends AppCompatActivity {

    RecyclerView recyclerView;
    Ten_day_Chellenge_Adapter adapter;
    ArrayList<SecondChellange> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal10day);

        arrayList = new ArrayList<>();

        arrayList.add(new SecondChellange(R.drawable.one,"Day99"));
        arrayList.add(new SecondChellange(R.drawable.two,"Day2"));
        arrayList.add(new SecondChellange(R.drawable.three,"Day3"));
        arrayList.add(new SecondChellange(R.drawable.four,"Day4"));
        arrayList.add(new SecondChellange(R.drawable.fivees,"Day5"));
        arrayList.add(new SecondChellange(R.drawable.six,"Day6"));
        arrayList.add(new SecondChellange(R.drawable.seven,"Day7"));

        adapter = new Ten_day_Chellenge_Adapter(arrayList,Goal_10day.this);

        recyclerView = findViewById(R.id.rec2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}