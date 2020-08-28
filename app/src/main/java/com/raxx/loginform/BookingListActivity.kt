package com.raxx.loginform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_booking_list.*
import java.util.ArrayList

class BookingListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_list)

        var bookList : ArrayList<Form>? = intent.getParcelableArrayListExtra<Form>("BookingList")
//        var form : String? = bookList?.get(0)
          var s:String = "Booking Id                Name             Number of Travellers \n "
        if (bookList != null) {
            Toast.makeText(applicationContext, "${bookList.size}", Toast.LENGTH_SHORT).show()
        }

        if (bookList != null) {
            for (i in bookList){
                s=s+i.Id+"            "+i.name+"           "+i.noOfTravellers+"\n"
            }
        }
        editTextTextMultiLine.setText(s)

//        val table:TableLayout=booktable
//        var trow : TableRow? =null
//        var ttext: TextView? =null
////        var ttext1: TextView? =null
//        ttext?.setText("dfghj")
////        ttext1?.setText("dfghj")
//        trow?.addView(ttext)
//        table.addView(trow,0)
    }

}