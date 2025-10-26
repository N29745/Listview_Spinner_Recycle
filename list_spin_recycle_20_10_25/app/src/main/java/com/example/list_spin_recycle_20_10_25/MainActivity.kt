package com.example.list_spin_recycle_20_10_25

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Data
        val buah = arrayOf("Apel", "Mangga", "Pisang", "Jeruk", "Semangka", "Anggur", "Durian")

        //adapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            buah
        )

        // adapter ke list view
        val listView: ListView = findViewById(R.id.myListView)
        listView.adapter = adapter

        // klik
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this,
                "Anda memilih: ${buah[position]}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}