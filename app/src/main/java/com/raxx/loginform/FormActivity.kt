package com.raxx.loginform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
    }

    fun logout(view: View) {
        finish()
    }

    override fun onBackPressed() {
        Toast.makeText(applicationContext,"Please Logout", Toast.LENGTH_LONG).show()
    }
}