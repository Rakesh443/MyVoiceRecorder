package com.raxx.loginform

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val USER_DATABASE = "UserDB"
val USER_TABLE_NAME = "UserTable"
val COL_USERID ="id"
val COL_UNAME = "name"
val COL_EMAIL="email"
val COL_DOB="dob"
val COL_PASS="pass"


class UserDataBaseHandler (var context:Context) : SQLiteOpenHelper(context, USER_DATABASE,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        var userTable = "CREATE TABLE "+ USER_TABLE_NAME + " ("+
                COL_USERID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_UNAME + " VARCHAR(256)," +
                COL_EMAIL+ " VARCHAR(256)," +
                COL_DOB+ " VARCHAR(256)," +
                COL_PASS+ " VARCHAR(256))";

        db?.execSQL(userTable)


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertuserData(user:User): Long {
        Toast.makeText(context,"Sucess $COL_UNAME ${user.name}", Toast.LENGTH_LONG).show()
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_UNAME,user.name)
        cv.put(COL_EMAIL,user.email)
        cv.put(COL_DOB,user.dob)
        cv.put(COL_PASS,user.pass)
        var result = db.insert(USER_TABLE_NAME,null,cv)
        if(result== -1.toLong()) Toast.makeText(context,"Error in DB", Toast.LENGTH_LONG).show()
        else {
            Toast.makeText(context,"Sucess $COL_UNAME ${user.name}", Toast.LENGTH_LONG).show()

        }
        return result
    }

    fun getUserData(s:String): String {
        val db = this.readableDatabase
        var r:String=""

        var query = "SELECT * FROM "+ USER_TABLE_NAME

        var result = db.rawQuery(query, null)

        if(result.moveToFirst()){
            do {

                if(s==result.getString(result.getColumnIndex(COL_UNAME))){
                        r=result.getString(result.getColumnIndex(COL_PASS))
                }



            }while (result.moveToNext())

        }
        return r

    }

    fun getallData(): ArrayList<User> {
        val db = this.readableDatabase
        var r:String=""

        var query = "SELECT * FROM "+ USER_TABLE_NAME
        var list = ArrayList<User>()
        var result = db.rawQuery(query, null)

        if(result.moveToFirst()){
            do {
                var user=User()
                user.dob = result.getString(result.getColumnIndex(COL_DOB))
                user.name = result.getString(result.getColumnIndex(COL_PNAME))
                user.email = result.getString(result.getColumnIndex(COL_EMAIL))
                list.add(user)
            }while (result.moveToNext())
        }
        return list

    }
}