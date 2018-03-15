package chapter03

//顶层属性 顶层方法

const val constString = "this is const String"

var opCount = 0

fun performOperation(){
    opCount++
}

fun reportOperationCount(){
    println("we do $opCount times operation")
}


//扩展函数
fun Int.nextValue() : Int = this + 1