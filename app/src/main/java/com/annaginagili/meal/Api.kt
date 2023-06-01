package com.annaginagili.meal

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("categories.php")
    fun getMeal() : Call<Model>

    @GET("search.php")
    fun getMealByName(@Query("s") s: String) : Call<Model>

    @GET("lookup.php")
    fun getMealById(@Query("i") i: String) : Call<Model>

    @GET("filter.php")
    fun getMealByCategory(@Query("c") c: String) : Call<Model>
}