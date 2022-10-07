package com.example.assignment4

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        createAccount.setOnClickListener {
            var myIntent = intent
            var fname:String
            var lname:String
            var emaill:String
            var passwordd:String
            if((firstname?.text?.length)!! < 1){
                firstname.setError("Please Enter firstname!")
            }
            else{
                fname = firstname?.text.toString()
                myIntent.putExtra("fname", fname)
            }
            if((lastname?.text?.length)!! < 1){
                lastname.setError("Please Enter lastname!")
            }
            else{
                lname = lastname?.text.toString()
                myIntent.putExtra("lname", lname)
            }
            if((email?.text?.length)!! < 1){
                email.setError("Please Enter email!")
            }
            else{
                emaill = email?.text.toString()
                myIntent.putExtra("email", emaill)
            }
            if((password?.text?.length)!! < 1){
                password.setError("Please Enter password!")
            }
            else{
                passwordd = password?.text.toString()
                myIntent.putExtra("password", passwordd)
            }

//            if(myIntent.getStringExtra("fname")?.isNotEmpty() == true && myIntent.getStringExtra("lname")?.isNotEmpty() == true
//                && myIntent.getStringExtra("emaill")?.isNotEmpty() == true &&
//                myIntent.getStringExtra("passwordd")?.isNotEmpty() == true){}
            if(myIntent.hasExtra("fname")&&myIntent.hasExtra("lname")&&myIntent.hasExtra("email")&&myIntent.hasExtra("password")){
                setResult(Activity.RESULT_OK, myIntent)
                finish()

                Toast.makeText(this, "Account successfully created!", Toast.LENGTH_SHORT).show()
            }

//            }


        }

    }
}