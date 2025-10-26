package com.example.spinner20_10_2025

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var selectedItemText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        spinner = findViewById(R.id.fruitSpinner)
        selectedItemText = findViewById(R.id.selectedItemText)

        val fruits = arrayOf(
            "Pilih buah...",
            "Apel",
            "Mangga",
            "Pisang",
            "Jeruk",
            "Semangka",
            "Anggur",
            "Durian"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            fruits
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedFruit = fruits[position]

                // Jangan tampilkan pesan untuk item "Pilih buah..."
                if (position > 0) {
                    selectedItemText.text = "Anda memilih: $selectedFruit"
                } else {
                    selectedItemText.text = "Belum ada yang dipilih"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedItemText.text = "Tidak ada yang dipilih"
            }
        }
    }
}