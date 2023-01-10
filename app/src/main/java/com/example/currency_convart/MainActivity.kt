package com.example.currency_convart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.Spinner
import com.example.currency_convart.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val countries = listOf(
        "BDT" to R.drawable.bangladesh,
        "Euro " to R.drawable.europe,
        "USD" to R.drawable.usa,
        "Pound" to R.drawable.uk,

    )
    lateinit var binding : ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ArrayAdapter(this, R.layout.dropdown_item, countries.map { it.first })
        adapter.setDropDownViewResource(R.layout.dropdown_item)
        binding.spinnerOne.adapter = adapter
        binding.spinnerTwo.adapter = adapter

        initUI()
    }

    private fun initUI(){

         // Set a listener on the spinner to update the flag image when a different country is selected
         binding.spinnerOne.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
             override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                 binding.flagImageViewOne.setImageResource(countries[position].second)
             }

             override fun onNothingSelected(parent: AdapterView<*>?) {}
         }
         // Set a listener on the spinner to update the flag image when a different country is selected
         binding.spinnerTwo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
             override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                 binding.flagImageViewTwo.setImageResource(countries[position].second)
             }

             override fun onNothingSelected(parent: AdapterView<*>?) {}
         }
    }
}