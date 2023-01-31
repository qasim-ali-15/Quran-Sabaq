package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.data.MyDbHandler;
import com.example.myapplication.model.QuranTable;

import java.util.List;

public class ViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        MyDbHandler myDbHandler = new MyDbHandler(this);
        List<QuranTable> quranTableList = myDbHandler.getStudentList();
        if(quranTableList.size()>0){
            StudentAdapter studentAdapter = new StudentAdapter(quranTableList, ViewActivity.this);
            recyclerView.setAdapter(studentAdapter);
        }
        else
        {
            Toast.makeText(this, "There is no element in Databse.", Toast.LENGTH_SHORT).show();
        }
    }
}