package com.pedroza.blogreader.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.pedroza.blogreader.model.Item;
import com.pedroza.blogreader.repository.BlogEntriesRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pedroza on 12/7/17.
 */

public class BlogEntriesActivityViewModel extends ViewModel {
    private BlogEntriesRepository mEntriesRepository;

    @Inject
    public BlogEntriesActivityViewModel(BlogEntriesRepository itemsRepository) {
        mEntriesRepository = itemsRepository;
    }

    public LiveData<List<Item>> getItems() {
        return mEntriesRepository.getItems();
    }

    public void loadBlogEntries() {
        mEntriesRepository.loadBlogEntries();
    }
}
