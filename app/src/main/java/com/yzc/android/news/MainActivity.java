package com.yzc.android.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static MainActivity mactivity;
    RecyclerView recyclerView;
    NewsAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mactivity=this;
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mAdapter = new NewsAdapter(this);
        recyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        initNews();
    }



    private void initNews() {
        News new1 = new News();
        new1.setTitle("I'm a new1 title");
        new1.setContent("We are new1 content!");
        mAdapter.addNew(new1);
        News new2 = new News();
        new2.setTitle("I'm a new2 title");
        new2.setContent("We are new2 content!");
        mAdapter.addNew(new2);
    }
}
