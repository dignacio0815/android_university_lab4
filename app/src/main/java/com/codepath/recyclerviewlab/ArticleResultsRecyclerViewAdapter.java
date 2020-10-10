package com.codepath.recyclerviewlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.recyclerviewlab.models.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleResultsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // Define a static int for each view type, loading = showing the loading spinner at the end of the list
    public static final int VIEW_TYPE_LOADING = 0;
    // article = each article that shows up
    public static final int VIEW_TYPE_ARTICLE = 1;
    private final List<Article> articleList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//       if (viewType == VIEW_TYPE_ARTICLE) {
//
//       }
//       else {
//           View view = LayoutInflater.from(parent.getContext())
//                   .inflate(R.layout.article_progress, parent, false);
//           return new LoadingViewHolder(view);
//       }
            View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_article_result, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        Article article = articleList.get(position);
        ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
        articleViewHolder.headlineView.setText(article.headline.main);
        articleViewHolder.snippetView.setText(article.snippet);

        // Bonus: Try searching up how to display the date using `SimpleDateFormat`
    }

    // This method clears the existing dataset and adds new articles
    void setNewArticles(List<Article> articles) {
        articleList.clear();
        articleList.addAll(articles);
    }

    // This method adds all articles to the existing dataset
    void addArticles(List<Article> articles) {
        articleList.addAll(articles);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
    static class ArticleViewHolder extends RecyclerView.ViewHolder {
        final TextView headlineView;
        final TextView snippetView;
        final TextView dateView;

        ArticleViewHolder(View view) {
            super(view);
            dateView = view.findViewById(R.id.article_pub_date);
            headlineView = view.findViewById(R.id.article_headline);
            snippetView = view.findViewById(R.id.article_snippet);
        }
    }
}

