package com.raxx.loginform

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var db = UserDataBaseHandler(this)
    //var sharedPreferences:SharedPreferences=getSharedPreferences("Login",Context.MODE_PRIVATE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        signupId.setOnClickListener {
            val  intent= Intent(this, SignupActivity::class.java)
            startActivity(intent)
//            var dialog= Dialog(this)
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            dialog.setCancelable(true)
//            dialog.setContentView(R.layout.otp)
//            val btn = dialog.findViewById(R.id.otpButton) as Button
//            btn.setOnClickListener { dialog.dismiss() }
//            dialog.show()

        }
    }

    fun login(view: View) {
        val name:String=nameId.text.toString()
        val pas:String=passId.text.toString()
//        val editor: SharedPreferences.Editor=sharedPreferences.edit()
//        editor.putString("Name",name)
//        editor.apply()

       // var s: ArrayList<User> =db.getallData()
        var t:String=db.getUserData(name)

        //Toast.makeText(applicationContext, "${s[1].name}", Toast.LENGTH_LONG).show()
        if(name.isNullOrEmpty() || pas.isNullOrEmpty()){
            Toast.makeText(applicationContext,"UserName or Password Cannot be Empty",Toast.LENGTH_LONG).show()
        }
        else if(pas.equals(t)){
            Toast.makeText(applicationContext, "$t ${pas}", Toast.LENGTH_SHORT).show()
            val  intent= Intent(this, SubmitActivity::class.java)
            passId.setText("")
            startActivity(intent)}
        else{
            Toast.makeText(applicationContext,"Invalid UserName and Password, Contact Admin",Toast.LENGTH_LONG).show()
        }
    }
}