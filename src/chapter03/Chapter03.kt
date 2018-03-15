package chapter03

fun main(args: Array<String>) {
    val strings = listOf("first", "second", "third")
    val list = arrayListOf(1, 2, 3)
    println(strings.last())
    println(list.max())
    println(strings.javaClass)
    println(list.javaClass)
    println(list)
    performOperation()
    reportOperationCount()
    println(1.nextValue())
}
