package com.igormelo.challenge.Services;

import com.google.gson.GsonBuilder;
import com.igormelo.challenge.Models.Item;
import com.igormelo.challenge.Models.PullRequests.Response;
import com.igormelo.challenge.PullRequest;
import com.igormelo.challenge.Repo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import rx.schedulers.Schedulers;


public interface RetrofitService {

   //Chamada dos repositorios
    @GET("/search/repositories")
    Call<Repo> getRepositories(@Query("q") String query,
                               @Query("sort") String sort,
                               @Query("page") int page);

    OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(18000, TimeUnit.SECONDS)
            .connectTimeout(18000, TimeUnit.SECONDS)
            .build();


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
            .client(client)
            .build();
//Chamada dos Pull Requests
    @GET("repos/{creator}/{repository}/pulls")
    Call<List<Response>> getPull(@Path("creator") String creator,
                                 @Path("repository") String repository);

}
