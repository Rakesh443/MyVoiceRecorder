package com.raxx.loginform

import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast


class Form() : Parcelable{
    var Id  :Int=0
    var name :String =""
    var noOfTravellers : Int =0

    constructor(parcel: Parcel) : this() {
        Id = parcel.readInt()
        name = parcel.readString().toString()
        noOfTravellers = parcel.readInt()
    }

    constructor(name:String,noOfTravellers:Int) : this() {
        this.name=name
        this.noOfTravellers=noOfTravellers
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Id)
        parcel.writeString(name)
        parcel.writeInt(noOfTravellers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Form> {
        override fun createFromParcel(parcel: Parcel): Form {
            return Form(parcel)
        }

        override fun newArray(size: Int): Array<Form?> {
            return arrayOfNulls(size)
        }
    }

}