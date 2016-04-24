package com.yzc.android.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by yzc on 2016/4/24.
 */
public class NewsContent extends AppCompatActivity {

    TextView newsTitle;
    TextView newsContent;

    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context, NewsContent.class);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("new_content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);

        newsTitle = (TextView) findViewById(R.id.news_title);
        newsContent = (TextView) findViewById(R.id.news_content);

        String title = getIntent().getStringExtra("news_title");
        String content = getIntent().getStringExtra("new_content");

        newsTitle.setText(title);
        newsContent.setText(content);
    }
}
