package com.example.recycle20_10_25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)

        // Create sample data
        val fruitList = listOf(
            Fruit("Apel", "Rp 25.000/kg"),
            Fruit("Mangga", "Rp 30.000/kg"),
            Fruit("Pisang", "Rp 15.000/sisir"),
            Fruit("Jeruk", "Rp 20.000/kg"),
            Fruit("Semangka", "Rp 18.000/kg"),
            Fruit("Anggur", "Rp 45.000/kg"),
            Fruit("Durian", "Rp 60.000/kg"),
            Fruit("Strawberry", "Rp 50.000/kg"),
            Fruit("Nanas", "Rp 12.000/kg"),
            Fruit("Melon", "Rp 22.000/kg")
        )

        // Create adapter
        val adapter = FruitAdapter(fruitList) { fruit ->
            // Handle item click
            Toast.makeText(this, "Anda memilih: ${fruit.name}", Toast.LENGTH_SHORT).show()
        }

        // Set layout manager and adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}