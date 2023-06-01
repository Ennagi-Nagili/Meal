package com.annaginagili.meal

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MealAdapter(private val context: Context, private val itemList: List<Meal>?, private val itemList2: List<MealSingle>?):
    RecyclerView.Adapter<MealAdapter.ItemHolder>() {
    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.image)
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val description = itemView.findViewById<TextView>(R.id.description)

        fun setData(item: Meal, context: Context) {
            this.name.text = item.strCategory
            this.description.text = item.strCategoryDescription
            Glide.with(context).load(Uri.parse(item.strCategoryThumb)).into(this.image)

            itemView.setOnClickListener {
                val intent1 = Intent(context, Catagorized::class.java)
                intent1.putExtra("category", item.strCategory)
                context.startActivity(intent1)
            }
        }

        fun setData2(item: MealSingle, context: Context) {
            this.name.text = item.strMeal
            Glide.with(context).load(Uri.parse(item.strMealThumb)).into(this.image)

            itemView.setOnClickListener {
                val intent1 = Intent(context, Search::class.java)
                intent1.putExtra("id", item.idMeal)
                context.startActivity(intent1)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.meal_layout, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList?.size ?: itemList2!!.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        if (itemList !== null) {
            holder.setData(itemList[position], context)
        }

        else {
            holder.setData2(itemList2!![position], context)
        }
    }
}