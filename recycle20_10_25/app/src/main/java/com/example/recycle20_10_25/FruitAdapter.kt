package com.example.recycle20_10_25


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter(
    private val fruitList: List<Fruit>,
    private val onItemClick: (Fruit) -> Unit
) : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {

    // ViewHolder class
    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFruitName: TextView = itemView.findViewById(R.id.namabuah)
        val tvFruitPrice: TextView = itemView.findViewById(R.id.hargabuah)
    }

    // Create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fruit, parent, false)
        return FruitViewHolder(view)
    }

    // Replace the contents of a view
    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = fruitList[position]

        holder.tvFruitName.text = fruit.name
        holder.tvFruitPrice.text = fruit.price

        // Handle item click
        holder.itemView.setOnClickListener {
            onItemClick(fruit)
        }
    }

    // Return the size of your dataset
    override fun getItemCount(): Int {
        return fruitList.size
    }
}