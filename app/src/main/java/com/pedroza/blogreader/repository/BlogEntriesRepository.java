package com.pedroza.blogreader.repository;

import android.arch.lifecycle.MutableLiveData;

import com.pedroza.blogreader.api.InVisionService;
import com.pedroza.blogreader.model.Item;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pedroza on 12/7/17.
 */

public class BlogEntriesRepository {

    private InVisionService mInvisionService;

    private MutableLiveData<List<Item>> mItems;

    private List<Item> mItemsInternal;

    @Inject
    public BlogEntriesRepository(InVisionService inVisionService) {

        mInvisionService = inVisionService;
        mItems = new MutableLiveData<>();
        mItemsInternal = new ArrayList<>();
    }

    public MutableLiveData<List<Item>> getItems() {
        return mItems;
    }

    public void loadBlogEntries() {
        Call<ResponseBody> loadBlogEntriesCall = mInvisionService.getInvisionRss();
        loadBlogEntriesCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                response.body();
                //
                //  Mocking Items for now. Not enough time to properly parse it.
                Item item = new Item();
                item.setTitle("Test Title 1");
                item.setDescription("Test Description 1");
                item.setLink("http://engineering.invisionapp.com/post/painless-microservices-migration/");

                List<Item> items = new ArrayList<>();
                for(int i=0; i<100; i++ ) {
                    items.add(item);
                }
                mItems.setValue(items);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}

