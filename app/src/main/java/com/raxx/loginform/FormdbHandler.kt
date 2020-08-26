package com.raxx.loginform

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


val DATABASE_NAME = "TrainDB"
val TABLE_NAME = "FormsTable"
val COL_PNAME = "name"
val COL_NUMBEROFTRAVELLERS="noOfTravellers"
val COL_ID="id"

class FormdbHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        var createTable = "CREATE TABLE "+ TABLE_NAME + " ("+
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_PNAME + " VARCHAR(256)," +
                COL_NUMBEROFTRAVELLERS+ " INTEGER)";
        //val context=this
        db?.execSQL(createTable)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(form:Form): Long {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_PNAME,form.name)
        cv.put(COL_NUMBEROFTRAVELLERS,form.noOfTravellers)
        var result = db.insert(TABLE_NAME,null,cv)
        if(result== -1.toLong()) Toast.makeText(context,"Error in DB",Toast.LENGTH_LONG).show()
        else Toast.makeText(context,"Sucess",Toast.LENGTH_LONG).show()
        return result

    }

    fun getDate() : ArrayList<Form>{
        val db=this.readableDatabase

        var list = ArrayList<Form>()
        var query = " SELECT * FROM "+ TABLE_NAME;
        var result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do {
                var form=Form()
                form.Id = result.getInt(result.getColumnIndex(COL_ID))
                form.name = result.getString(result.getColumnIndex(COL_PNAME))
                form.noOfTravellers = result.getInt(result.getColumnIndex(COL_NUMBEROFTRAVELLERS))
                list.add(form)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

}