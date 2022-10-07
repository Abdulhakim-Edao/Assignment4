package com.example.assignment4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.email
import kotlinx.android.synthetic.main.activity_main.password
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {


    val users:ArrayList<User> = ArrayList<User>()
    var u1: User = User("Ab", "Ed", "abc@gmail.com", "1234")
    var u2: User = User("Jhon", "Doe", "jhon@gmail.com", "1234")
    var u3: User = User("Sarah", "Ab", "sarah@gmail.com", "1234")
    var u4: User = User("Feven", "Li", "feven@gmail.com", "1234")
    var u5: User = User("Jay", "Mo", "jay@gmail.com", "1234")
    init {
        users.add(u1)
        users.add(u2)
        users.add(u3)
        users.add(u4)
        users.add(u5)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var resContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == Activity.RESULT_OK){
                var fname = result.data?.getStringExtra("fname")
                var lname = result.data?.getStringExtra("lname")
                var mail = result.data?.getStringExtra("email")
                var passw = result.data?.getStringExtra("password")
                var u: User = User(fname.toString(), lname.toString(), mail.toString(), passw.toString())
                users.add(u)
                email?.setText(mail)
                password?.setText(passw)
            }

        }
        createAccountm.setOnClickListener{
            val myIntent = Intent(this, RegisterActivity::class.java)
            resContract.launch(myIntent)
        }

    }

    fun signin(view: View){

        var eml = email.text.toString()
        var pas = password.text.toString()
        if(eml.length == 0){
            email.error = "Please enter email!"
        }
        if(pas.length==0){
            password.error = "Please enter password!"
        }
        for (em in users){

            if (eml.equals(em.username) && pas.equals(em.password)){
                val myIntent = Intent(this@MainActivity, ShoppingActivity::class.java)
                var mail = em.username
                myIntent.putExtra("mail", mail)
                startActivity(myIntent)
                break
            }
            else{
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun forgetPassword(view: View){
        val eml = email.text.toString()
        for (em in users){

            if ((eml?.length)!! > 0 && eml.equals(em.username)){
                val emailIntent = Intent(Intent.ACTION_SEND)
                emailIntent.putExtra(Intent.EXTRA_EMAIL, email.text.toString())
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Password")
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Your password is: ${em.password.toString()}")
//
                emailIntent.type = "message/rfc822"

                if(emailIntent.resolveActivity(packageManager)!= null){
                    startActivity(Intent.createChooser(emailIntent, "Choose an Email app"))
                }
                break
            }
            else{
                email.error = "Please enter the correct email!"
            }
        }

    }

}