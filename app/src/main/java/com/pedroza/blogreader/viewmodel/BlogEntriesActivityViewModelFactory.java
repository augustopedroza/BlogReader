package com.pedroza.blogreader.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;

/**
 * Created by pedroza on 12/7/17.
 */

public class BlogEntriesActivityViewModelFactory implements ViewModelProvider.Factory{
    private BlogEntriesActivityViewModel mViewModel;

    @Inject
    public BlogEntriesActivityViewModelFactory(BlogEntriesActivityViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BlogEntriesActivityViewModel.class)) {
            return (T) mViewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
