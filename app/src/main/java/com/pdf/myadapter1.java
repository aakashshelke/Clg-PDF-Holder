package com.pdf;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class myadapter1 extends FirebaseRecyclerAdapter<model, myadapter1.myViewHolder>
{

    ArrayList<String> array = new ArrayList<String>();
    public myadapter1(@NonNull FirebaseRecyclerOptions<model> options, Context context, ArrayList<String> array) {
        super(options);
        this.array = array;
    }


    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull model model) {

        holder.name.setText(model.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dept = array.get(0);
                String year = array.get(1);
                Intent intent = new Intent(holder.itemView.getContext(), ChoosePdf.class);
                intent.putExtra("subject", model.getName());
                intent.putExtra("dept", dept);
                intent.putExtra("year", year);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selectsubjectsinglerow, parent, false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        public myViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.sub);
        }
    }

}
