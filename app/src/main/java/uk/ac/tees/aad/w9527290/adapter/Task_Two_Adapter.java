package uk.ac.tees.aad.w9527290.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;
import uk.ac.tees.aad.w9527290.Models.Task_One_Model;
import uk.ac.tees.aad.w9527290.R;
import uk.ac.tees.aad.w9527290.activities.Task1_pos;
import uk.ac.tees.aad.w9527290.activities.Task2_pos;

public class Task_Two_Adapter extends RecyclerView.Adapter<Task_Two_Adapter.viewholder> {

    public ArrayList<Task_One_Model> arrayList;
    Context context;

    public Task_Two_Adapter(ArrayList<Task_One_Model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task1_row,parent,false);
        return new Task_Two_Adapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.Pose.setImageResource(arrayList.get(position).getImagepos());
        holder.Rabs.setText(arrayList.get(position).getRaps());
        holder.Target.setText(arrayList.get(position).getTargetArea());
        holder.exerName.setText(arrayList.get(position).getExcerciseName());

        holder.Pose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0)
                {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises",0);
                    context.startActivity(intent);

                }
                if(position == 1) {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises", 1);
                    context.startActivity(intent);

                }
                if(position == 2)
                {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises",2);
                    context.startActivity(intent);

                }
                if(position == 3)
                {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises",3);
                    context.startActivity(intent);
                }
                if(position == 4)
                {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises",4);
                    context.startActivity(intent);
                }
                if(position == 5)
                {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises",5);
                    context.startActivity(intent);
                }
                if(position == 6)
                {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises",6);
                    context.startActivity(intent);
                }
                if(position == 7)
                {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises",7);
                    context.startActivity(intent);
                }
                if(position == 8)
                {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises",8);
                    context.startActivity(intent);
                }
                if(position == 9)
                {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises",9);
                    context.startActivity(intent);
                }
                if(position == 10)
                {
                    Intent intent = new Intent(context, Task2_pos.class);
                    intent.putExtra("exercises",10);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
       return arrayList.size();
    }

    class viewholder extends RecyclerView.ViewHolder
    {

        GifImageView Pose;
        TextView Rabs;
        TextView Target;
        TextView exerName;


        public viewholder(@NonNull View itemView) {
            super(itemView);



            Pose = itemView.findViewById(R.id.imageView2);
            Target = itemView.findViewById(R.id.task1targetArea);
            Rabs = itemView.findViewById(R.id.task1raps);
            exerName = itemView.findViewById(R.id.Task1exerciseName);


        }
    }
}
