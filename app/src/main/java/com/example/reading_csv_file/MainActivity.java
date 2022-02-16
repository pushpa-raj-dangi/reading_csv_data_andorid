package com.example.reading_csv_file;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private final List<Student> students = new ArrayList<>();
        private void readDataResource(){
        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        String line = "";
        try {
            while((line = bufferedReader.readLine()) !=null){
                String[] columns = line.split(",");
                Student student = new Student();

                student.setFirstName(columns[1]);
                student.setLastName(columns[2]);
                student.setEthnicity(columns[4]);
                student.setGender(columns[5]);
                String str = Arrays.toString(columns);
                Log.e("studetns", "hello"+str);

                students.add(student);
            }
        } catch (IOException e) {
            Log.e("Error", "readDataResource: ",e );
            e.printStackTrace();
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readDataResource();

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new DataAdapter(this,students));
    }


}