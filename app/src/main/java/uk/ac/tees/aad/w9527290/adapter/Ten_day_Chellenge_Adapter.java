package uk.ac.tees.aad.w9527290.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uk.ac.tees.aad.w9527290.Models.FirstChellange;
import uk.ac.tees.aad.w9527290.Models.SecondChellange;
import uk.ac.tees.aad.w9527290.R;
import uk.ac.tees.aad.w9527290.activities.Task1;
import uk.ac.tees.aad.w9527290.activities.Task2;

public class Ten_day_Chellenge_Adapter extends RecyclerView.Adapter<Ten_day_Chellenge_Adapter.viewholder> {

    public ArrayList<SecondChellange> arrayList;
    Context context;

    public Ten_day_Chellenge_Adapter(ArrayList<SecondChellange> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.five_day_recyclerview_item,parent,false);
        return new Ten_day_Chellenge_Adapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.img1.setImageResource(arrayList.get(position).getFirst_img());


        holder.txt.setText(arrayList.get(position).getDayText());
        holder.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==0) {
                    {
                        Intent intent = new Intent(context, Task2.class);
                        intent.putExtra("days", 1);
                        context.startActivity(intent);
                       // Toast.makeText(context.getApplicationContext(), "Clciked", Toast.LENGTH_SHORT).show();
                    }}
                if(position==1) {
                    {
                        Intent intent = new Intent(context, Task2.class);
                        intent.putExtra("days", 2);
                        context.startActivity(intent);
                      //  Toast.makeText(context.getApplicationContext(), "Clciked", Toast.LENGTH_SHORT).show();
                    }}
                if(position==2) {
                    {
                        Intent intent = new Intent(context, Task2.class);
                        intent.putExtra("days", 3);
                        context.startActivity(intent);
                      //  Toast.makeText(context.getApplicationContext(), "Clciked", Toast.LENGTH_SHORT).show();
                    }}
                if(position==3) {
                    {
                        Intent intent = new Intent(context, Task2.class);

                        intent.putExtra("days", 4);

                        context.startActivity(intent);
                       // Toast.makeText(context.getApplicationContext(), "Clciked", Toast.LENGTH_SHORT).show();
                    }}
                if(position==4) {
                    {
                        Intent intent = new Intent(context, Task2.class);
                        intent.putExtra("days", 5);
                        context.startActivity(intent);
                      //  Toast.makeText(context.getApplicationContext(), "Clciked", Toast.LENGTH_SHORT).show();
                    }}
                if(position==5) {
                    {
                        Intent intent = new Intent(context, Task2.class);

                        intent.putExtra("days", 6);

                        context.startActivity(intent);
                     //   Toast.makeText(context.getApplicationContext(), "Clciked", Toast.LENGTH_SHORT).show();
                    }}
                if(position==6) {
                    {
                        Intent intent = new Intent(context, Task2.class);
                        intent.putExtra("days", 7);
                        context.startActivity(intent);
                     //   Toast.makeText(context.getApplicationContext(), "Clciked", Toast.LENGTH_SHORT).show();
                    }}


            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class viewholder extends RecyclerView.ViewHolder
    {

        ImageView img1;
        TextView txt;
        EditText lock;


        public viewholder(@NonNull View itemView) {
            super(itemView);




            img1 = itemView.findViewById(R.id.imageView3);
            txt = itemView.findViewById(R.id.textView6);

        }
    }
}
