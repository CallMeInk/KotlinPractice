class KotlinTest{
    //public 申明的函数返回值也不必明确写出返回类型
    public fun sum(a: Int, b: Int) = a + b
}

fun main(args: Array<String>) {
    val kotlinTest = KotlinTest()
    println(kotlinTest.sum(1, 2))
}