package com.example.reading_csv_file.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.reading_csv_file.view.DataAdapter;
import com.example.reading_csv_file.R;
import com.example.reading_csv_file.entity.Student;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private final List<Student> students = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gettingItemsFromCSV();

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new DataAdapter(this,students));
    }


    private void gettingItemsFromCSV() {

        BufferedInputStream bufferedInputStream = new BufferedInputStream(getResources().openRawResource(R.raw.students));

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(bufferedInputStream));

        try {
            int i=0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                i++;
                String[] columns = line.split(",");

                Student student = new Student();
                if(i > 1){
                    student.setFirstName(columns[2]);
                    student.setLastName(columns[3]);
                    student.setDateOfBirth(columns[4]);
                    student.setGender(columns[6]);

                    students.add(student);
                    Log.i("Test123", columns[0]);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}