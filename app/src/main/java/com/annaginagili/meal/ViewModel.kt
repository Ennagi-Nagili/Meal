package com.annaginagili.meal

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel : ViewModel() {
    private var mealLiveData = MutableLiveData<Model>()
    fun getMeal() {
        RetrofitClient.getInstance().getApi().getMeal().enqueue(object:
            Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.body()!=null){
                    mealLiveData.value = response.body()!!
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("hello",t.message.toString())
            }
        })
    }

    fun getMealByName(name: String) {
        RetrofitClient.getInstance().getApi().getMealByName(name).enqueue(object:
            Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.body()!=null){
                    mealLiveData.value = response.body()!!
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("hello",t.message.toString())
            }
        })
    }

    fun getMealById(id: String) {
        RetrofitClient.getInstance().getApi().getMealById(id).enqueue(object:
            Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.body()!=null){
                    mealLiveData.value = response.body()!!
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("hello",t.message.toString())
            }
        })
    }

    fun getMealByCategory(category: String) {
        RetrofitClient.getInstance().getApi().getMealByCategory(category).enqueue(object:
            Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.body()!=null){
                    mealLiveData.value = response.body()!!
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("hello",t.message.toString())
            }
        })
    }

    fun observeMealLiveData() : LiveData<Model> {
        return mealLiveData
    }
}