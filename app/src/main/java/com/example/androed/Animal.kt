package com.example.androed

open class Animal : AnimNoize{
    open val food = ""
    open val habitat = ""

    open fun makeNoise() {
        println("Животное издаёт звук")
    }

    open fun eat() {
        println("Животное ест")
    }

    open fun sleep() {
        println("Животное спит")
    }
}