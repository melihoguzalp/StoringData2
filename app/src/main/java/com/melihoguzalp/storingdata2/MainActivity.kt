package com.melihoguzalp.storingdata2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var ageFromDatabase : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Shared Preferences Initialized
        sharedPreferences = this.getSharedPreferences("com.melihoguzalp.storingdata2", Context.MODE_PRIVATE)

        ageFromDatabase = sharedPreferences.getInt("age",-1)

        if (ageFromDatabase == -1)
        {
            textView.text = "Your age :"

        }

        else{

            textView.text ="Your Age :" + ageFromDatabase
        }

    }


    fun save(view: View){

        //Shared Preferences -- Database oluşturmus oluruz





        val myAge = editText.text.toString().toIntOrNull()

        if(myAge != null){

            textView.text = "Your Age : " + myAge
            sharedPreferences.edit().putInt("age", myAge).apply()


        }


    }

    fun delete(view: View){

        ageFromDatabase = sharedPreferences.getInt("age",-1)

        if(ageFromDatabase != -1){

            sharedPreferences.edit().remove("age").apply()
            textView.text = "Your Age :"

        }


    }


}
