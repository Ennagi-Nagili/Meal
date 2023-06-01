package com.annaginagili.meal

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.annaginagili.meal.databinding.ActivitySearchBinding
import com.bumptech.glide.Glide

class Search : AppCompatActivity() {
    lateinit var binding: ActivitySearchBinding
    lateinit var image: ImageView
    lateinit var name: TextView
    lateinit var category: TextView
    lateinit var instructions: TextView
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        image = binding.image
        name = binding.name
        category = binding.category
        instructions = binding.instructions

        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.observeMealLiveData().observe(this) {
            val result = it.meals!![0]
            Glide.with(this).load(Uri.parse(result.strMealThumb)).into(image)
            name.text = result.strMeal
            category.text = result.strCategory
            instructions.text = result.strInstructions
        }

        if (intent.getStringExtra("search") != null) {
            viewModel.getMealByName(intent.getStringExtra("search")!!)
        }

        else {
            viewModel.getMealById(intent.getStringExtra("id")!!)
        }
    }
}