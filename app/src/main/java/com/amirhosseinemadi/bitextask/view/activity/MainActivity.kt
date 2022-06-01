package com.amirhosseinemadi.bitextask.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.amirhosseinemadi.bitextask.R
import com.amirhosseinemadi.bitextask.databinding.ActivityMainBinding
import com.amirhosseinemadi.bitextask.view.fragment.TradeFragment
import com.amirhosseinemadi.bitextask.view.fragment.EmptyFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initLayout()
    }


    private fun initLayout()
    {
        binding.bottomNav.setOnItemSelectedListener(this::onItemSelected)
        binding.bottomNav.selectedItemId = R.id.trade
    }


    private fun onItemSelected(item:MenuItem) : Boolean
    {
        when (item.itemId)
        {
            R.id.trade -> { supportFragmentManager.beginTransaction().replace(binding.frame.id,
                TradeFragment()
            ).commit() }

            else -> { supportFragmentManager.beginTransaction().replace(binding.frame.id,EmptyFragment()).commit() }
        }

        item.isChecked = true

        return false
    }
}