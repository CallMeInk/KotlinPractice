package chapter02

import kotlin.math.max

class Chapter02Class(
        val name: String,
        var isMarried: Boolean){

    val nameLength: Int
        get() = name.length

    fun max(a: Int, b: Int): Int{
        return if (a > b) a else b
    }

    fun max1(a: Int, b: Int) = if (a > b) a else b
}

enum class Color(val r: Int, val g: Int, val b: Int){
    RED(255, 0, 0),
    BLUE(0, 0, 255);

    fun rgb() = (r * 255 + g) * 255 + b

    fun getRGB(color: Color) =
            when(color){
                RED -> "red"
                BLUE -> "blue"
            }
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int{
    if (e is Num){
        return e.value
    }
    if (e is Sum){
        return eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("unknown exception")
}

fun main(args: Array<String>) {
    println("Hello World!")
    println(max(1, 2))
    println(max(3, 4))
    val classInstance = Chapter02Class("", false)
    println("${classInstance.isMarried}")
    println(classInstance.nameLength)
    println("rgb::${Color.BLUE.rgb()}")
    println("getRGB::${Color.RED.getRGB(Color.BLUE)}")
    println(eval(Sum(Sum(Num(1),Num(2)), Num(4))))
    println(1 in 5 .. 3)
}