package com.raxx.loginform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_train_list.*
import java.util.ArrayList

class TrainListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train_list)
        val trainList = trainDummyList(100)
        recycle1.adapter = TrainAdapter(trainList)
        recycle1.layoutManager= LinearLayoutManager(this)

        recycle1.setHasFixedSize(true)


    }

    private fun trainDummyList(size : Int) : List<Train>{
        val list = ArrayList<Train>()
            var i=12074
            var j=0
        while (j<=size) {i++
            j++
            val train = Train(R.drawable.ic_baseline_train_24,i,"Train Name")
            list+=train}
        return list
    }
}