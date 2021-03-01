package com.example.outofbusinesscards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.example.outofbusinesscards.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()
        PreferenceManager.getDefaultSharedPreferences(this).apply {
            val company = getString("company","")
            val postal = getString("postal","")
            val address = getString("address","")
            val tel = getString("tel","")
            val fax = getString("fax","")
            val email = getString("email","")
            val url = getString("url","")
            val position = getString("position","")
            val name = getString("name","")

            binding.companyText.text = company
            binding.postalText.text = postal
            binding.addressText.text = address
            binding.telText.text = "tel:" + tel
            binding.faxText.text = "fax:" + fax
            binding.emailText.text = email
            binding.urlText.text = url
            binding.positionText.text = position
            binding.nameText.text = name

        }
    }

}