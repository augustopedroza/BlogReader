package com.pedroza.blogreader.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.pedroza.blogreader.R;
import com.pedroza.blogreader.model.Item;
import com.pedroza.blogreader.view.adapter.BlogEntriesAdapter;
import com.pedroza.blogreader.viewmodel.BlogEntriesActivityViewModel;
import com.pedroza.blogreader.viewmodel.BlogEntriesActivityViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created by pedroza on 12/7/17.
 */

public class BlogEntriesActivity extends AppCompatActivity {

    @Inject
    BlogEntriesActivityViewModelFactory mViewModelFactory;

    private BlogEntriesActivityViewModel mViewModel;

    private BlogEntriesAdapter mBlogEntriesAdapter;

    @BindView(R.id.list_items_rv)
    protected RecyclerView mListItemsRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_entries);

        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(BlogEntriesActivityViewModel.class);
        mViewModel.getItems().observe(this, items -> {
            //
            // update UI
            //
            setupOrUpdateAdapter(items);
        });

        mViewModel.loadBlogEntries();
    }


    private void setupOrUpdateAdapter(List<Item> items) {

        if (mBlogEntriesAdapter != null) {
            mBlogEntriesAdapter.setItems(items);
            mBlogEntriesAdapter.notifyDataSetChanged();

        } else {
            mBlogEntriesAdapter = new BlogEntriesAdapter(items);
            mListItemsRv.setAdapter(mBlogEntriesAdapter);
        }
    }
}
