package uk.ac.tees.aad.w9527290.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import uk.ac.tees.aad.w9527290.Models.Task_One_Model;
import uk.ac.tees.aad.w9527290.R;
import uk.ac.tees.aad.w9527290.adapter.Task_One_Adapter;
import uk.ac.tees.aad.w9527290.adapter.Task_Two_Adapter;

public class Task2 extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    ArrayList<Task_One_Model> arrayList;

    Task_Two_Adapter adapter;
    int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        SharedPreferences sharedpreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        String UserName= sharedpreferences.getString("Name", null);
        editor.commit();

        textView = findViewById(R.id.task2et);
        textView.setText(" Welcome " + UserName);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        recyclerView = findViewById(R.id.rectask2);
        if(b!=null)
        {
            arrayList = new ArrayList<>();
            day = (int) b.get("days");
            // textView.setText("Hey " + UserName + " Welcome to day " + j+"");

        }
        if(day ==1) {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 20", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 20", "Band Hand", "Targets Hands", R.drawable.bandhand));

        }
        if(day ==2) {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 20", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 20", "Band Hand", "Targets Hands", R.drawable.bandhand));
            arrayList.add(new Task_One_Model("No of Raps 30", "Celiling Reach", "Legs and Ankles", R.drawable.ceilingreach));


        }
        if(day ==3) {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 20", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 20", "Band Hand", "Targets Hands", R.drawable.bandhand));
            arrayList.add(new Task_One_Model("No of Raps 30", "Celiling Reach", "Legs and Ankles", R.drawable.ceilingreach));
            arrayList.add(new Task_One_Model("No of Raps 30", "lunges", "Legs ", R.drawable.lunges));

        }
        if(day ==4) {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 20", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 20", "Band Hand", "Targets Hands", R.drawable.bandhand));
            arrayList.add(new Task_One_Model("No of Raps 30", "Celiling Reach", "Legs and Ankles", R.drawable.ceilingreach));
            arrayList.add(new Task_One_Model("No of Raps 30", "lunges", "Legs ", R.drawable.lunges));
            arrayList.add(new Task_One_Model("No of Raps 35", "Hips leg", "Hips ", R.drawable.chiarleg));


        }
        if(day ==5) {
            arrayList = new ArrayList<>();

            arrayList.add(new Task_One_Model("No of Raps 20", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 20", "Band Hand", "Targets Hands", R.drawable.bandhand));
            arrayList.add(new Task_One_Model("No of Raps 30", "Celiling Reach", "Legs and Ankles", R.drawable.ceilingreach));
            arrayList.add(new Task_One_Model("No of Raps 30", "lunges", "Legs ", R.drawable.lunges));
            arrayList.add(new Task_One_Model("No of Raps 35", "Hips leg", "Hips ", R.drawable.chiarleg));
            arrayList.add(new Task_One_Model("No of Raps 30", "lunges", "Legs ", R.drawable.lunges));

        }
        if(day ==6) {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 20", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 20", "Band Hand", "Targets Hands", R.drawable.bandhand));
            arrayList.add(new Task_One_Model("No of Raps 30", "Celiling Reach", "Legs and Ankles", R.drawable.ceilingreach));
            arrayList.add(new Task_One_Model("No of Raps 30", "lunges", "Legs ", R.drawable.lunges));
            arrayList.add(new Task_One_Model("No of Raps 35", "Hips leg", "Hips ", R.drawable.chiarleg));
            arrayList.add(new Task_One_Model("No of Raps 30", "lunges", "Legs ", R.drawable.lunges));
            arrayList.add(new Task_One_Model("No of Raps 30", "push up", "whole ", R.drawable.pushup));


        }
        if(day ==7) {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 20", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 20", "Band Hand", "Targets Hands", R.drawable.bandhand));
            arrayList.add(new Task_One_Model("No of Raps 30", "Celiling Reach", "Legs and Ankles", R.drawable.ceilingreach));
            arrayList.add(new Task_One_Model("No of Raps 30", "lunges", "Legs ", R.drawable.lunges));
            arrayList.add(new Task_One_Model("No of Raps 35", "Hips leg", "Hips ", R.drawable.chiarleg));
            arrayList.add(new Task_One_Model("No of Raps 30", "lunges", "Legs ", R.drawable.lunges));
            arrayList.add(new Task_One_Model("No of Raps 30", "push up", "whole ", R.drawable.pushup));
            arrayList.add(new Task_One_Model("No of Raps 30", "push up", "whole ", R.drawable.day_five));



        }

        //  arrayList.add(new Task_One_Model("Sss","s","Ss",R.drawable.day_five));
        adapter = new Task_Two_Adapter(arrayList,Task2.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}