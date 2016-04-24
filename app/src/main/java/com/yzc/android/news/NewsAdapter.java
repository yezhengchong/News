package com.yzc.android.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzc on 2016/4/24.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder>{
    private Context Context;
    private LayoutInflater inflater;
    private List<News> items = new ArrayList<>();

    public NewsAdapter(Context context) {
        this.Context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.news_item, parent, false);
        NewsHolder holder = new NewsHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        if (items != null) {
            //holder.newTitle.setText(items.get(position).getTitle().toString());
            News news = items.get(position);
            holder.bindNews(news);
        }
    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        else
            return 0;
    }

    public void addNew(News news) {
        items.add(news);
        notifyItemChanged(items.size());
    }

    public class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView newTitle;

        private News mNew;
        public NewsHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            newTitle = (TextView) itemView.findViewById(R.id.news_title);
        }

        public void bindNews(News news) {
            mNew = news;
            newTitle.setText(mNew.getTitle().toString());
        }

        @Override
        public void onClick(View v) {
            //Toast.makeText(Context, mNew.getTitle(), Toast.LENGTH_SHORT).show();
            NewsContent.actionStart(Context, mNew.getTitle(), mNew.getContent());
        }
    }
}
