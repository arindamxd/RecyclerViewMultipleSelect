package com.arindam.androidmultiple.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arindam.androidmultiple.R;
import com.arindam.androidmultiple.adapter.CardViewDataAdapter;
import com.arindam.androidmultiple.model.Student;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Student> studentList;

    private Button btnSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnSelection = (Button) findViewById(R.id.btnShow);

        studentList = new ArrayList<Student>();
        for (int i = 1; i <= 200; i++) {
            Student st = new Student("Student " + i, "androidstudent" + i + "@gmail.com", false);
            studentList.add(st);
        }

        /*if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Android Students");
        }*/

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // create an Object for Adapter
        mAdapter = new CardViewDataAdapter(studentList);

        // set the adapter object to the RecyclerView
        mRecyclerView.setAdapter(mAdapter);

        btnSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "";
                List<Student> stList = ((CardViewDataAdapter) mAdapter).getStudentList();

                for (int i = 0; i < stList.size(); i++) {
                    Student singleStudent = stList.get(i);
                    if (singleStudent.isSelected() == true) {

                        data = data + "\n" + singleStudent.getName().toString();
                        /*
                        * Toast.makeText( CardViewActivity.this, " " +
                        * singleStudent.getName() + " " +
                        * singleStudent.getEmailId() + " " +
                        * singleStudent.isSelected(),
                        * Toast.LENGTH_SHORT).show();
                        */
                    }

                }

                Toast.makeText(CardViewActivity.this, "Selected Students: \n" + data, Toast.LENGTH_LONG).show();
            }
        });
    }
}