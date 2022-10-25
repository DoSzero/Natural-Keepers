package com.nak.naturalkeepers.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.*
import com.nak.naturalkeepers.*
import com.nak.naturalkeepers.databinding.ActivityHomeBinding
import com.nak.naturalkeepers.databinding.ActivitySplahBinding
import com.nak.naturalkeepers.model.SharedPreferences.bestTimeValue
import com.nak.naturalkeepers.model.SharedPreferences.numberOfWords
import com.nak.naturalkeepers.utils.getSharedPrefInt
import com.nak.naturalkeepers.utils.getSharedPrefString
import com.nak.naturalkeepers.utils.storeSharedPref


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViews()

        binding.playGame.setOnClickListener {
            val myIntent = Intent(this, GameActivity::class.java)
            startActivity(myIntent)
        }

        val items = (6..10).toList()
        binding.spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) { }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                storeSharedPref(numberOfWords, items[position])
            }
        }

        // Default value for the spinner
        if (getSharedPrefInt(numberOfWords) != -1) {
            binding.spinner.setSelection(items.indexOf(getSharedPrefInt(numberOfWords)))
        } else {
            binding.spinner.setSelection(2)
        }
    }

    private fun setUpViews() {
        var bestTimeText = binding.bestTime
    }

    // time from shared preferences
    private fun updateBestTime() {
       binding.bestTime.text = if (getSharedPrefString(bestTimeValue) == null) {
           "Неизвестный"
        } else {
            getSharedPrefString(bestTimeValue) + " сек."
        }
    }

    override fun onResume() {
        super.onResume()
        updateBestTime()
    }

}