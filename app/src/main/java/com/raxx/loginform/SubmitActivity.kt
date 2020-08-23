package com.raxx.loginform

import android.app.DatePickerDialog
import android.content.Intent
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
        pickDate()
    }

    private fun pickDate() {
        dateId.setOnClickListener{
            getDate()
            DatePickerDialog(this,this, year,month,day).show()

        }
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

    fun book(view: View) {}
    fun trainList(view: View) {
        val  intent= Intent(this, TrainListActivity::class.java)
        startActivity(intent)
    }


}