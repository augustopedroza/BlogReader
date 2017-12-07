package com.pedroza.blogreader.viewmodel;

import android.databinding.ObservableField;

import com.pedroza.blogreader.model.Item;

/**
 * Created by pedroza on 12/7/17.
 */

public class BlogEntryViewModel {
    public ObservableField<String> itemTitle = new ObservableField<>();
    public ObservableField<String> itemDescription = new ObservableField<>();

    private Item mBlogItem;

    public void setItem(Item blogItem) {
        this.mBlogItem = blogItem;
        itemTitle.set(mBlogItem.getTitle());
        itemDescription.set(mBlogItem.getDescription());

    }
}
