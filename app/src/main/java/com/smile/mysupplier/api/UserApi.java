package com.smile.mysupplier.api;

import com.smile.mysupplier.model.response.HotMenus;
import com.smile.mysupplier.model.response.HotMenusByCategory;
import com.smile.mysupplier.model.response.MenuCategories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hendrigunawan on 5/31/17.
 */

public interface UserApi {

    @GET("hot-menu-categories")
    @Headers({
            "Content-Type: application/json"
    })
    Call<HotMenus> hotMenus();

    @GET("hot-menus/{category}")
    @Headers({
            "Content-Type: application/json"
    })
    Call<HotMenusByCategory> hotMenusByCategory(@Path("category") Integer category, @Query("search") String search);

    @GET("menus/{categoryId}")
    @Headers({
            "Content-Type: application/json"
    })
    Call<HotMenusByCategory> menusByCategory(@Path("categoryId") Integer category, @Query("search") String search);

    @GET("menu-categories")
    @Headers({
            "Content-Type: application/json"
    })
    Call<MenuCategories> menuCategories();

}
