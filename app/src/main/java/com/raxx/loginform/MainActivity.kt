package com.raxx.loginform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View) {
        val name:String=nameId.text.toString()
        val pas:String=passId.text.toString()
//        val editor:SharedPreferences.Editor=sharedPreferences.edit()
//        editor.putString("Name",name)
//        editor.putBoolean("Check",true)
//        editor.apply()
        if(name.isNullOrEmpty() || pas.isNullOrEmpty()){
            Toast.makeText(applicationContext,"UserName or Password Cannot be Empty",Toast.LENGTH_LONG).show()
        }
        else if(name.equals(pas.reversed())){
            val  intent= Intent(this, FormActivity::class.java)
            startActivity(intent)}
        else{
            Toast.makeText(applicationContext,"Invalid UserName and Password, Contact Admin",Toast.LENGTH_LONG).show()
        }
    }
}