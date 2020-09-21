package com.example.androed

class Student(val fod: String, val hom: String) : Animal() {
    override val food = fod
    override val habitat = hom

    override fun makeNoise() {
        println("Хочу кушать!")
    }

    override fun eat() {
        println("Он ничего не ест, так как денег на $food нету")
    }

    override fun sleep() {
        println("Смотрит на тебя, и не спит")
    }
}