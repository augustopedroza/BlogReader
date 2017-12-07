package com.pedroza.blogreader.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pedroza on 12/7/17.
 */

public interface InVisionService {
    @GET("index.html")
    Call<ResponseBody> getInvisionRss();
}
