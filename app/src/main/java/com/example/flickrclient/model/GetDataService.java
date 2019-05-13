package com.example.flickrclient.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("services/rest/?method=flickr.photos.getRecent&page=1&format=json&nojsoncallback=1")
    Call<Flicker> getRecentPhotos(@Query("api_key") String apiKey, @Query("per_page") Integer perPage);





}
