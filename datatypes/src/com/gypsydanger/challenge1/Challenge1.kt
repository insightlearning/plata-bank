package com.gypsydanger.challenge1

fun main(args: Array<String>) {
    val hello1 = "Hello"
    val hello2 = "Hello"

    println(hello1 === hello2)  //referential equality
    println(hello1 == hello2)   //structural equality

    var myNumber: Int = 2988

    val text: Any = "The Any type is the root of the Kotlin class hierarchy"

    //smart cast, the type is converted only inside de if
    if (text is String)
        println(text.toUpperCase())

    //a regular cast
    //text as String
    //println(text.toUpperCase())

    println(
        """1   1
          1  11
          1 111
          11111
                """.trimMargin("1")
    )
}