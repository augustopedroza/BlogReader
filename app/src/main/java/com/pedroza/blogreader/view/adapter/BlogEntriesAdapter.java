package com.pedroza.blogreader.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pedroza.blogreader.R;
import com.pedroza.blogreader.databinding.CardViewBlogEntryBinding;
import com.pedroza.blogreader.model.Item;
import com.pedroza.blogreader.viewmodel.BlogEntryViewModel;

import java.util.List;

/**
 * Created by pedroza on 12/7/17.
 */

public class BlogEntriesAdapter extends RecyclerView.Adapter<BlogEntriesAdapter.EntryHolder> {

    private List<Item> mBlogItems;

    public BlogEntriesAdapter(List<Item> items) {
        mBlogItems = items;
    }

    @Override
    public EntryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardViewBlogEntryBinding entryBiding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.card_view_blog_entry,
                parent,
                false);

        return new EntryHolder(entryBiding);
    }

    @Override
    public void onBindViewHolder(EntryHolder holder, int position) {
        holder.bind(mBlogItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mBlogItems.size();
    }

    public void setItems(List<Item> blogItems) {
        this.mBlogItems = blogItems;
        notifyDataSetChanged();
    }


    public static class EntryHolder extends RecyclerView.ViewHolder {

        private CardViewBlogEntryBinding mBinding;

        public EntryHolder(CardViewBlogEntryBinding itemBinding) {
            super(itemBinding.entryCardView);
            this.mBinding = itemBinding;
            this.mBinding.setViewModel(new BlogEntryViewModel());
        }

        public void bind(Item item) {
            mBinding.getViewModel().setItem(item);
            mBinding.executePendingBindings();
        }
    }
}