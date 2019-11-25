package com.gypsydanger.arrays

fun main(args: Array<String>) {
    val names = arrayOf("Joseph", "Vito", "Carlos", "Giorgio")

    val long1 = arrayOf(1L, 2L, 3L)
    val long2 = arrayOf<Long>(1, 3, 6, 9)

    println(long2[3])

    val sixtyNumbers = Array(16) {i -> i+1} //generate values using lambda
    for(number in sixtyNumbers){
        println(number)
    }

    //arrays can also have any kind of types
    val mixedArrays = arrayOf("String", 1, 1.0f, 1L, true, 'c')
    for(values in mixedArrays){
        println(values)
    }
    println(mixedArrays is Array<*>)
}