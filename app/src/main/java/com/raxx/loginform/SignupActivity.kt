package com.raxx.loginform

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_submit.*
import java.util.*

class SignupActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    var day =0
    var month =0
    var year =0

    var savedDay ="DD"
    var savedMonth ="MM"
    var savedYear ="YYYY"
    val context=this
    var db = UserDataBaseHandler(context)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        rdateId.setOnClickListener {
            val cal = Calendar.getInstance()
            day=cal.get(Calendar.DAY_OF_MONTH)
            month=cal.get(Calendar.MONTH)
            year= cal.get((Calendar.YEAR))
            var dialog:DatePickerDialog =DatePickerDialog(this,this, year,month,day)
            dialog.datePicker.maxDate=Calendar.getInstance().timeInMillis
            dialog.show()
        }



        rsignup.setOnClickListener {
            var flag=0
            if(rname.text.isEmpty()) {
                rname.setError("Name cannot be Empty")
                rname.requestFocus()
                flag++
            }
            if(rEmailAddress.text.isEmpty()){
                rEmailAddress.setError("Email cannot be Empty")
                rname.requestFocus()
                flag++
            }
            if(rdateOfBirth.text.isEmpty()){
                rdateOfBirth.setError("Date of Birth cannot be Empty")
                rdateOfBirth.requestFocus()
                flag++
            }
            if(rpass1.text.isEmpty()){
                rpass1.setError("Password cannot be Empty")
                rpass1.requestFocus()
                flag++
            }
            if (rpass1.text.toString()!=rpass2.text.toString()){
                rpass2.setError("Password didn't match")
                rpass2.requestFocus()
                flag++
                Toast.makeText(context, "${rpass1.text} ${rpass2.text}", Toast.LENGTH_SHORT).show()
            }

            if(flag==0){
                //otpdialog()
                register()
            }

        }
    }

    private fun otpdialog() {
        var dialog=Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.otp)
        val btn = dialog.findViewById(R.id.otpButton) as Button
        btn.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }

    private fun register() {
        var user=User(rname.text.toString(),rEmailAddress.text.toString(),rdateId.text.toString(),rpass1.text.toString())
      var result= db.insertuserData(user)
        if(result==-1.toLong()) Toast.makeText(context, "Error in Register", Toast.LENGTH_SHORT).show()
        else {
            Toast.makeText(context, "Sucessfully Registered $result", Toast.LENGTH_SHORT).show()
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        savedYear=p1.toString()
        savedMonth=p2.toString()
        savedDay=p3.toString()
        var s:String = savedDay+"/"+savedMonth+"/"+savedYear
        rdateOfBirth.setText(s)
    }
}