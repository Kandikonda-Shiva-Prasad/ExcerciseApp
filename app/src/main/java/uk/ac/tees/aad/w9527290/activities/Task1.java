package uk.ac.tees.aad.w9527290.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import uk.ac.tees.aad.w9527290.Models.Task_One_Model;
import uk.ac.tees.aad.w9527290.R;
import uk.ac.tees.aad.w9527290.adapter.Task_One_Adapter;

public class Task1 extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    ArrayList<Task_One_Model> arrayList;

    Task_One_Adapter adapter;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        SharedPreferences sharedpreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        String UserName= sharedpreferences.getString("Name", null);
        editor.commit();



        textView = findViewById(R.id.task1et);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        recyclerView = findViewById(R.id.rectask1);



        if(b!=null)
        {
            arrayList = new ArrayList<>();
            day = (int) b.get("day");
           // textView.setText("Hey " + UserName + " Welcome to day " + j+"");



        }



        if(day ==1) {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 10", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 10", "Band Hand", "Targets Hands", R.drawable.bandhand));

        }
        if(day ==2)
        {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 11", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 11", "Band Hand", "Targets Hands", R.drawable.bandhand));
            arrayList.add(new Task_One_Model("No of Raps 11","Back Legs","Targets Legs",R.drawable.backlegs));

        }
        if(day ==3)
        {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 12", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 12", "Band Hand", "Targets Hands", R.drawable.bandhand));
            arrayList.add(new Task_One_Model("No of Raps 12","Back Legs","Targets Legs",R.drawable.backlegs));
            arrayList.add(new Task_One_Model("No of Raps 12","UP Hands","Targets Hands",R.drawable.day_five));

        }
        if(day ==4)
        {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 12", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 12", "Band Hand", "Targets Hands", R.drawable.bandhand));
            arrayList.add(new Task_One_Model("No of Raps 12","Back Legs","Targets Legs",R.drawable.backlegs));
            arrayList.add(new Task_One_Model("No of Raps 12","UP Hands","Targets  Hands",R.drawable.day_five));
            arrayList.add(new Task_One_Model("No of Raps 12","ceiling reach","Hand & Back",R.drawable.ceilingreach));

        }
        if(day ==5)
        {
            arrayList = new ArrayList<>();
            arrayList.add(new Task_One_Model("No of Raps 15", "Slow Running", "Full Body", R.drawable.slowwalk));
            arrayList.add(new Task_One_Model("No of Raps 15", "Band Hand", "Targets Hands", R.drawable.bandhand));
            arrayList.add(new Task_One_Model("No of Raps 15","Back Legs","Targets Legs",R.drawable.backlegs));
            arrayList.add(new Task_One_Model("No of Raps 15","UP Hands","Targets Hands",R.drawable.day_five));
            arrayList.add(new Task_One_Model("No of Raps 15","ceiling reach","Hand & Back",R.drawable.ceilingreach));
            arrayList.add(new Task_One_Model("No of Raps 15","Crunches","Whole Body",R.drawable.ballcrunches));

        }

      //  arrayList.add(new Task_One_Model("Sss","s","Ss",R.drawable.day_five));
        adapter = new Task_One_Adapter(arrayList,Task1.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}