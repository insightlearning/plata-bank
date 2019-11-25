package com.gypsydanger.nullpointer

fun main(args: Array<String>) {
    val str: String? = null //the ? indicate this val can be null. Otherwise it doesnt compile.

    if (str != null) {
        println(str.toUpperCase())
    }

    println(str?.toUpperCase())     //same expression that above

    //the elvis operator ?:
    val str2: String = str ?: "Some default value in case of null"
    println(str2)

    //nice use of ?
    //val myTeam = continent?.country?.state?.city?.team ?: "I dont like football"

    val something: Any = arrayOf(1, 2, 3)
    val str3 = something as? String
    println(str3)
}