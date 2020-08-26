package com.raxx.loginform

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.trainlist_card.view.*

class TrainAdapter(private val trainList:List<Train>) : RecyclerView.Adapter<TrainAdapter.TrainViewHolder>(){

    class TrainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val imageView : ImageView = itemView.recycleImage
        val trainNo : TextView = itemView.recycleTrainNo
        val trainName : TextView = itemView.recycleTrainName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainViewHolder {

        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.trainlist_card,parent,false)

        return TrainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TrainViewHolder, position: Int) {
        val currentItem=trainList[position]

        holder.imageView.setImageResource(currentItem.image)
        holder.trainName.text=currentItem.trainName
        holder.trainNo.text= currentItem.trainNo.toString()
    }

    override fun getItemCount()= trainList.size

}