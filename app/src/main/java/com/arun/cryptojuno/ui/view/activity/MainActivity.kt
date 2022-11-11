package com.arun.cryptojuno.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arun.cryptojuno.R
import com.arun.cryptojuno.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}