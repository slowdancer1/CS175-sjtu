package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private  SearchAdapter mSearchAdapter = new SearchAdapter();
    private EditText txt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mSearchAdapter);
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            {
                items.add("这是第"+String.valueOf(i)+"行");
            }
        mSearchAdapter.notifyItems(items);}

    public void search(View view) {
        txt=(EditText)findViewById(R.id.input);
        int x=Integer.parseInt(txt.getText().toString());
        if (!(x>=0)){x=0;}
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        if (i%10==x | i/10==x){
            items.add("这是第"+String.valueOf(i)+"行");
        }
        mSearchAdapter.notifyItems(items);}

}
        /*
        private EditText txt = null;
        private Button btn = null;btn=(Button)findViewById(R.id.button);
        txt=(EditText)findViewById(R.id.input);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int x=Integer.parseInt(txt.getText().toString());

            }
        });*/