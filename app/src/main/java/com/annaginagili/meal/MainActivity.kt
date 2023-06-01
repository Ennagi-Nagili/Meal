package com.annaginagili.meal

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.annaginagili.meal.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var adapter: MealAdapter
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModel
    lateinit var input: EditText
    lateinit var search: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        recycler = binding.recycler
        input = binding.input
        search = binding.search

        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.observeMealLiveData().observe(this) {
            recycler.setHasFixedSize(true)
            recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = MealAdapter(this, it.categories!!, null)
            recycler.adapter = adapter
        }
        viewModel.getMeal()

        search.setOnClickListener {
            if (input.text.toString().isNotEmpty()) {
                val intent1 = Intent(this, Search::class.java)
                intent1.putExtra("search", input.text.toString())
                startActivity(intent1)
            }
        }
    }
}