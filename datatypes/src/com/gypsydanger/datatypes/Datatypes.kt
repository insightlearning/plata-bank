package com.gypsydanger.datatypes

fun main(args: Array<String>) {
    //Ways to declare ans assign
    val myByte: Byte = 11
    val myShort: Short = 111
    val myInt = 1111
    val myLong = 11111L

    //convertions
    var myShort2 = 5.toShort()
    var myByte2 = 0
    val myInt2 = myByte2

    val myDouble = 64.98
    val myFloat = 64.98F

    val myNewDouble = myFloat.toDouble()

    val char = 'b'
    val myCharAsInt = 65        //In Kotlin is no possible to associate number to char
    println(myCharAsInt.toChar())

    val myBoolean = true
    println(Dummy().isVacationTime(myBoolean))
}