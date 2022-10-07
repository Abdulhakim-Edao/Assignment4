package com.example.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        val myrIntent = intent
        val mails = myrIntent.getStringExtra("mail")
        welcomeText.text = "Welcome "+mails
    }

    fun click(view: View){
        when(view.id){
            R.id.electronics->{
                Toast.makeText(this, "You clicked electronics category", Toast.LENGTH_SHORT).show()
            }
            R.id.clothing->{
                Toast.makeText(this, "You clicked clothing category", Toast.LENGTH_SHORT).show()
            }
            R.id.beauty->{
                Toast.makeText(this, "You clicked beauty category", Toast.LENGTH_SHORT).show()
            }
            R.id.food->{
                Toast.makeText(this, "You clicked food category", Toast.LENGTH_SHORT).show()
            }
        }
    }
}