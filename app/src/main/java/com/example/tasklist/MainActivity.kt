package com.example.tasklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)

        this.findNavController(R.id.navHostFragment).addOnDestinationChangedListener(){ _, destination, _ ->
            when(destination.id){
                R.id.firstTaskFragment ->   toolbar.visibility = View.GONE
                R.id.taskInputDialogFragment -> toolbar.visibility = View.GONE
                else -> toolbar.visibility = View.VISIBLE
            }
//            if (destination.id == R.id.firstTaskFragment){
//                toolbar.visibility = View.GONE
//            }else{
//                toolbar.visibility = View.VISIBLE
//            }
        }
    }

}