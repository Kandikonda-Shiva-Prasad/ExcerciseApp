package uk.ac.tees.aad.w9527290.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;
import uk.ac.tees.aad.w9527290.Models.Item;
import uk.ac.tees.aad.w9527290.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewholder> {

    public ArrayList<Item> arrayList;
    public Context context;

    public ItemAdapter(ArrayList<Item> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new ItemAdapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        Glide.with(context).load(arrayList.get(position).getItemImg()).into(holder.itemimg);
       // holder.itemimg.setImageResource(arrayList.get(position).getItemImg());
        holder.itemText.setText(arrayList.get(position).getItemName());
        holder.itemkcal1.setText(arrayList.get(position).getItemKcal());
        holder.itemKcal2.setText(arrayList.get(position).getItemKcal2());
    }

    @Override
    public int getItemCount() {
         return  arrayList.size();
    }

    class viewholder extends RecyclerView.ViewHolder
    {

      ImageView itemimg;
      TextView itemText;
      TextView itemkcal1;
      TextView itemKcal2;


        public viewholder(@NonNull View itemView) {
            super(itemView);



           itemimg = itemView.findViewById(R.id.itemimg);
           itemText = itemView.findViewById(R.id.itemname);
           itemkcal1 = itemView.findViewById(R.id.kal1);
           itemKcal2 = itemView.findViewById(R.id.kal2);


        }
    }
}
