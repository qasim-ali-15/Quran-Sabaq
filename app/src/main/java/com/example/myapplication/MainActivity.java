package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.data.MyDbHandler;
import com.example.myapplication.model.QuranTable;

public class MainActivity extends AppCompatActivity {
    MyDbHandler MyDb = new MyDbHandler(MainActivity.this);

    Button btnAdd,btnView,btnRepos;
    EditText textName,textSabaq,textSabaqi,textManzil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler db = new MyDbHandler(MainActivity.this);

        textName = (EditText) findViewById(R.id.textName);
        textSabaq = (EditText) findViewById(R.id.textSabaq);
        textSabaqi = (EditText) findViewById(R.id.textSabqi);
        textManzil = (EditText) findViewById(R.id.textManzil);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView =(Button) findViewById(R.id.btnView);
        btnRepos =(Button) findViewById(R.id.btnRepos);

        btnRepos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://github.com/qasim-ali-15/QuranAyat");
            }

            private void goLink(String s) {
                Uri uri= Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        
        addData();
        //viewData();

        //creating new object in db
        //QuranTable stu1= new QuranTable();
        //stu1.setName("Qasim");

        //adding data in DB
        //db.addStudent(stu1);
    }

    public void addData() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //QuranTable Student;
                String name = textName.getText().toString();
                String sabaq = textSabaq.getText().toString();
                String sabaqi = textSabaqi.getText().toString();
                String manzil = textManzil.getText().toString();

                if (name.length() <= 0 || sabaq.length() <= 0 || sabaqi.length() <= 0 || manzil.length() <= 0)
                    Toast.makeText(MainActivity.this, "Please Enter all the information", Toast.LENGTH_SHORT).show();
                else {
                    QuranTable obj = new QuranTable(name, sabaq, sabaqi, manzil);
                    MyDb.addStudent(obj);
                    Toast.makeText(MainActivity.this, "Data Entered Sucessfully", Toast.LENGTH_SHORT).show();

                    finish();
                    startActivity(getIntent());
                }


            }
        });


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });
    }
}