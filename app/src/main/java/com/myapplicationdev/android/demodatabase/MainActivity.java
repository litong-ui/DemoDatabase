package com.myapplicationdev.android.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ListView lv;
    CustomAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DBHelper db = new DBHelper(this);
//        db.getWritableDatabase();
//        db.close();

        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);
        lv = findViewById(R.id.lv);


        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
//                ArrayList<String> data = db.getTaskContent();
                ArrayList<Task> tasks = db.getTasks();
//                ArrayList<Task> tasks = new ArrayList<>();
//
//                Task t1 = new Task(1, "abc", "abc");
//                Task t2 = new Task(2, "rrr", "a0908bc");
//                tasks.add(t1);
//                tasks.add(t2);

//                db.close();

//                String txt = "";
//                for (int i = 0; i < data.size(); i++) {
//                    Log.d("Database Content", i +". "+data.get(i));
//                    txt += i + ". " + data.get(i) + "\n";
//                }
//                tvResults.setText(txt);

//                DBHelper dbHelper = new DBHelper(MainActivity.this);
//                tasks = dbHelper.getTasks();
//                ca = new CustomAdapter(MainActivity.this, R.layout.row,tasks);
                ArrayAdapter aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, tasks);


                lv.setAdapter(ca);
            }
        });


    }
}