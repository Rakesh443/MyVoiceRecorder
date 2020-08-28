package com.raxx.loginform

class User {
    var name:String=""
    var email:String=""
    var dob:String=""
    var pass:String=""

    constructor(name: String, email: String, dob: String, pass: String) {
        this.name = name
        this.email = email
        this.dob = dob
        this.pass = pass
    }
    constructor()
}