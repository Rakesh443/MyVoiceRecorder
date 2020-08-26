package com.raxx.loginform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.util.ArrayList

class BookingListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_list)

        var bookList : ArrayList<Form>? = intent.getParcelableArrayListExtra<Form>("BookingList")
//        var form : String? = bookList?.get(0)

        if (bookList != null) {
            Toast.makeText(applicationContext, "${bookList.size}", Toast.LENGTH_SHORT).show()
        }

    }

//    getListId.setOnClickListener{
//        var result = db.getDate()
//        val  intent= Intent(this, BookingListActivity::class.java)
//        intent.putExtra("BookingList",result)
//        startActivity(intent)
//
//    }
}