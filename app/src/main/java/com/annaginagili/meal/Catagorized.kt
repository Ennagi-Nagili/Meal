package com.annaginagili.meal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.annaginagili.meal.databinding.ActivityCatagorizedBinding
import com.annaginagili.meal.databinding.ActivityMainBinding

class Catagorized : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var adapter: MealAdapter
    lateinit var binding: ActivityCatagorizedBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCatagorizedBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        recycler = binding.recycler

        Log.e("hello", "cata")

        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.observeMealLiveData().observe(this) {
            recycler.setHasFixedSize(true)
            recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = MealAdapter(this, null, it.meals)
            recycler.adapter = adapter
        }
        viewModel.getMealByCategory(intent.getStringExtra("category")!!)
    }
}