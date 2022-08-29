package uk.ac.tees.aad.w9527290.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import uk.ac.tees.aad.w9527290.R;
import uk.ac.tees.aad.w9527290.adapter.PageAdapter;


public class MainScreen extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseDatabase database;
    TextView bmrtxt;
    TabLayout tabLayout;
    TabItem Five,Ten,Fifteen;
    ViewPager viewPager;
    PageAdapter pagerAdapter;
    SharedPreferences sharedpreferences;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);



        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().show();
        sharedpreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        tabLayout = findViewById(R.id.tabLayout);
        Five = findViewById(R.id.fiveday);
        Ten = findViewById(R.id.Tenday);
       // Fifteen = findViewById(R.id.fifteneday);

        viewPager = findViewById(R.id.viewpager2);
        pagerAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);


        auth = FirebaseAuth.getInstance();
        bmrtxt = findViewById(R.id.bmr_txt);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());



                if(tab.getPosition() ==0 || tab.getPosition()==1||tab.getPosition()==2)
                {
                    pagerAdapter.notifyDataSetChanged();


                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {



            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("user")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid());


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String Name = snapshot.child("name").getValue(String.class);

                String Gender =  snapshot.child("gender").getValue(String.class);
                Float Height =  snapshot.child("height").getValue(Float.class);
                Float Weight =  snapshot.child("weight").getValue(Float.class);
              //  Toast.makeText(MainScreen.this,Height+"",Toast.LENGTH_LONG).show();

                double bmrs = BMRCalculation(Height,Weight,Gender);

                Toast.makeText(MainScreen.this,bmrs+"",Toast.LENGTH_LONG).show();


                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("Name", Name);
                editor.putFloat("Height",Height);
                editor.commit();

                bmrtxt.setText("BMR " + bmrs);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public  double BMRCalculation(float height,float Weight,String Gender)
    {
       // Men: BMR = 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) – (5.677 x age in years)
      //  Women: BMR = 447.593 + (9.247 x weight in kg) + (3.098 x height in cm) – (4.330 x age in years)
        double bmr=0;
        switch (Gender)
        {
            case "Male":
                 bmr = 88.362 + (13.397 * Weight) + (4.799 * height) - (5.677*25);
                break;
            case "Female":
                bmr = 447.593 + (9.247 * Weight) + (3.098 * height) - (4.330*25);
                break;

        }
         return  Math.round(bmr);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.signout:
              //  Intent intent = new Intent(MainScreen.this, BMR_LIST.class);
              //  startActivity(intent);
              //  break;
            case R.id.bmr_track:
                Intent intent1 = new Intent(MainScreen.this,BMR_LIST.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }
}