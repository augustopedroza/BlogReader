package com.pedroza.blogreader.di;

import com.pedroza.blogreader.view.BlogEntriesActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by pedroza on 12/7/17.
 */

@Module
public abstract class ActivityBuilderModule {
    //
    // Dagger > 2.10 offers this convenient way to inform the dependency graph that
    // an activity needs injection.
    // From the documentation:
    // Pro-tip: If your subcomponent and its builder have no other methods or supertypes than the
    // ones mentioned in step #2, you can use @ContributesAndroidInjector to generate them for you.
    // Instead of steps 2 and 3, add an abstract module method that returns your activity, annotate
    // it with @ContributesAndroidInjector, and specify the modules you want to install into the subcomponent.
    // If the subcomponent needs scopes, apply the scope annotations to the method as well.
    //

    @ContributesAndroidInjector(modules = {})
    abstract BlogEntriesActivity contributeBlogEntriesActivityInjector();
}
