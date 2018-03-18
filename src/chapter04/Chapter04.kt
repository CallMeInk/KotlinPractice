package chapter04

import chapter03.performOperation

interface Clickable{
    fun click()
    fun showOff() = println("interface clickable showOff")
}

interface Focusable{
    fun showOff() = println("interface focusable showOff")
}

class Button: Clickable, Focusable{

    //每次实例化一个类的时候均会执行init 和java的static不一样
    init {
        println("class button init")
    }

    init {
        println("class button init 2")
    }

    override fun click() = println("I'm clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

sealed class Expr{
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
    //class NewSubClass() : Expr()
}

fun evaluate(e: Expr): Int =
        when(e){
            is Expr.Num -> e.value
            is Expr.Sum -> evaluate(e.left) + evaluate(e.right)
        }

open class View(val arg1: Int, val arg2: Int, val arg3: Int)

class MyView : View{

    constructor(arg1: Int) : this(arg1, 2,3)

    constructor(arg1: Int, arg2: Int) : this(arg1, arg2, 3)

    constructor(arg1: Int, arg2: Int, arg3: Int) : super(arg1, arg2, arg3){
        //do sth
    }

}

interface User{
    val nickname: String
}

class Privateuser(override val nickname: String) : User

class SubscribeUser(val email: String) : User{
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : User{
    override val nickname: String = "facebook user name"
}

class User2(val name: String) {
    var address: String = "no address"
        set(value) {
            println("old address is $address")
            println("new address is $value")
            field = value
        }
}

class Client(val name: String, val postalCode: Int){
    override fun equals(other: Any?): Boolean =
            if (other == null || other !is Client)
                false
            else
                other.name == this.name &&
                        other.postalCode == this.postalCode
}

open class Base{

    constructor(){
        println("Base no param constructor")
    }

    open fun log() = println("base log")
}

class Son : Base{

    constructor(){
        println("Son no param constructor")
    }

    override fun log(){
        println("son log")
        super.log()
    }
}


fun main(args: Array<String>) {
    val button = Button()
    button.click()
    button.showOff()
    println(evaluate(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4))))
    val button2 = Button()
    println(Privateuser("privateUser nickname").nickname)
    println(SubscribeUser("yukai@123.com").nickname)
    println(FacebookUser(123).nickname)
    val user2 = User2("Alice")
    user2.address = "SOHO 15#"
    val client1 = Client("Alice", 111)
    val client2 = Client("Alice", 111)
    println("client1 == client2:: ${client1 == client2}")
    val son = Son()
    son.log()
}