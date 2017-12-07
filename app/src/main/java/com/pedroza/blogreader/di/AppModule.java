package com.pedroza.blogreader.di;

import com.pedroza.blogreader.api.InVisionService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pedroza on 12/7/17.
 */

@Module
public class AppModule {
    @Singleton
    @Provides
    InVisionService provideInVisionService() {

        //
        //  OkHttp3 injector allows me to add the api_key paramter to every request
        //

        return new Retrofit.Builder()
                .baseUrl("http://engineering.invisionapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .readTimeout(20_000, TimeUnit.MILLISECONDS)
                        .writeTimeout(20_000, TimeUnit.MILLISECONDS)
                        .connectTimeout(20_000, TimeUnit.MILLISECONDS)
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                        .build())
                .build()
                .create(InVisionService.class);
    }

}
