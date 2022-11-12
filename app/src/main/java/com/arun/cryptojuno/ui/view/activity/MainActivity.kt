package com.arun.cryptojuno.ui.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arun.cryptojuno.R
import com.arun.cryptojuno.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnEmptyState.setOnClickListener {
            openStateActivity(0)
        }
        binding.btnValueState.setOnClickListener {
            openStateActivity(1)
        }
    }

    private fun openStateActivity(pageState : Int){
        val intent = Intent(this, StateActivity::class.java)
        intent.putExtra("pageState",pageState)
        startActivity(intent)
    }
}