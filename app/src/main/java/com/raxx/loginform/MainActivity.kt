package com.raxx.loginform

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.otp.*

class MainActivity : AppCompatActivity() {
    var db = UserDataBaseHandler(this)
    private val TIME_INTERVAL = 2000
    private var mBackPressed: Long = 0
    //var sharedPreferences:SharedPreferences=getSharedPreferences("Login",Context.MODE_PRIVATE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        signupId.setOnClickListener {
            val  intent= Intent(this, SignupActivity::class.java)
            startActivity(intent)


        }

        forgotId.setOnClickListener {
            Toast.makeText(applicationContext, "forgot shdgfsfhvhf", Toast.LENGTH_SHORT).show()
            if(nameId.text.toString().length<0) {
                nameId.setError("Enter Phone Number")
            }
            var list = db.getallData()
            var j=0
            for(i in list){

                if(i.name.toString()==nameId.text.toString())
                    j++
            }
            if(j>0){
                val numb:String="9700349127"
                val mesg:String="4565"
                val sms: SmsManager =SmsManager.getDefault()
                sms.sendTextMessage(numb,null,mesg,null,null)

                var intent = Intent(Intent.ACTION_VIEW);
                verify(mesg)
            }

        }
    }

    override fun onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
           finish()
            return
        } else {
            Toast.makeText(baseContext, "Tap back button in order to exit", Toast.LENGTH_SHORT)
                .show()
        }
        mBackPressed = System.currentTimeMillis()
    }

    private fun verify(mesg: String) {
        var dialog= Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.otp)
        val btn = dialog.findViewById(R.id.otpButton) as Button
        btn.setOnClickListener { dialog.dismiss() }
        dialog.show()
        if(otp.text.toString()==mesg){
            val  intent1= Intent(this, SubmitActivity::class.java)
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