package chapter06

fun <T> copyElement(source: Collection<T>, target: MutableCollection<T>){
    for (item in source){
        target.add(item)
    }
}

class NullTest(var count: Int){

    var stringTest: String? = "not empty"

    fun printString(message: String?){
        println(message)
    }
}

class Test : NullInterfaceTest{
    override fun printMessage(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun main(args: Array<String>) {
    var nullTest : NullTest? = null
    nullTest?.count ?: println("null detected")
    nullTest?.count = 1
    println(nullTest)
    println("".isNullOrEmpty())
    val nullString: String? = null
    println("null is nullOrExpty::${nullString.isNullOrEmpty()}")
    println("test::::${nullTest?.stringTest.isNullOrEmpty()}")
    val source = arrayListOf(1, 2, 3)
    val target = arrayListOf(4)
    copyElement(source, target)
    println(target)
    val strings = Array<String>(3){ ('a' + it).toString() }
    println("strings::$strings")
    val toTypedArray = listOf(1, 2, 3)
    println("%s|%s|%s".format(*toTypedArray.toTypedArray()))
}