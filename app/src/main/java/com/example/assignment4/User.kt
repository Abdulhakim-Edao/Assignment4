package com.example.assignment4

import java.io.Serializable

data class User(val firstname: String, val lastname: String, val username:String, val password:String):
    Serializable {

}
