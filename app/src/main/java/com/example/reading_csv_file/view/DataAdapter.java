package com.example.reading_csv_file.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reading_csv_file.R;
import com.example.reading_csv_file.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    Context context;

    private List<Student> students = new ArrayList<>();

    public DataAdapter(Context context,List<Student> students) {
        this.context = context;

    this.students = students;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.single_item, null);
        MyViewHolder viewHolder = new MyViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv1.setText("First Name : "+students.get(position).getFirstName());
        holder.tv3.setText("Lastname : "+students.get(position).getLastName());
        holder.tv2.setText(" Gender : "+students.get(position).getGender());


    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv;

        public MyViewHolder(View convertView) {
            super(convertView);
            tv1 = convertView.findViewById(R.id.tv1);
            tv3 = convertView.findViewById(R.id.tv3);
            tv2 = convertView.findViewById(R.id.tv2);



        }
    }

}