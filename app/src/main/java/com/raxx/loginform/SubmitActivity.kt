package com.raxx.loginform

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_submit.*
import java.util.*

class SubmitActivity : AppCompatActivity(),DatePickerDialog.OnDateSetListener {
    var day =0
    var month =0
    var year =0

    var savedDay ="DD"
    var savedMonth ="MM"
    var savedYear ="YYYY"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        //pickDate()

        val context=this
        var db = FormdbHandler(context)
        bookId.setOnClickListener {
            if(sname.text.toString().length>0 && noOfTravellersId.text.toString().length > 0){
                var form = Form(sname.text.toString(),noOfTravellersId.text.toString().toInt())

                db.insertData(form)
            }
            else{
                Toast.makeText(applicationContext,"Enter valid Name and Number of Passengers", Toast.LENGTH_LONG).show()
            }

        }

        logoutId.setOnClickListener{
//            var sharedPreferences: SharedPreferences =getSharedPreferences("Login", Context.MODE_PRIVATE)
//            val editor: SharedPreferences.Editor=sharedPreferences.edit()
//            editor.putString("Name","")
//            editor.apply()
            finish()
//            var result = db.detDate()
//            for(i in result){
//                Toast.makeText(applicationContext,"Passengers ${i.name}", Toast.LENGTH_LONG).show()
//            }
        }
        getListId.setOnClickListener{
        var result = db.getDate()
        val  intent= Intent(this, BookingListActivity::class.java)
        intent.putParcelableArrayListExtra("BookingList",result)
        startActivity(intent)

    }


        dateId.setOnClickListener{
            getDate()
            var dialog:DatePickerDialog =DatePickerDialog(this,this, year,month,day)
            dialog.datePicker.minDate=Calendar.getInstance().timeInMillis
            dialog.show()

        }
    }

    override fun onBackPressed() {
        Toast.makeText(applicationContext, "Please Logout", Toast.LENGTH_SHORT).show()
    }

    private fun getDate(){
        val cal = Calendar.getInstance()
        day=cal.get(Calendar.DAY_OF_MONTH)
        month=cal.get(Calendar.MONTH)
        year= cal.get((Calendar.YEAR))
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        savedYear=p1.toString()
        savedMonth=p2.toString()
        savedDay=p3.toString()
        var s:String = savedDay+"/"+savedMonth+"/"+savedYear
        date.setText(s)
    }

//    fun datepick(view: View) {
//        getDate()
//        DatePickerDialog(this,this, year,month,day).show()
//        Toast.makeText(applicationContext,"$savedYear $savedMonth $savedDay", Toast.LENGTH_LONG).show()
//        // var date1
//    }

    fun trainList(view: View) {
        val  intent= Intent(this, TrainListActivity::class.java)
        startActivity(intent)
    }

}