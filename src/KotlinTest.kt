class KotlinTest{
    //public 申明的函数返回值也不必明确写出返回类型
    public fun sum(a: Int, b: Int) = a + b

    fun sum1(a: Int, b: Int) = a + b

    //vararg 可变长度数组
    fun printVars(vararg v: Int){
        for (number in v){
            print(String.format("%d, ", number))
        }
        println()
    }
}

fun main(args: Array<String>) {
    val kotlinTest = KotlinTest()
    println(kotlinTest.sum(1, 2))
    kotlinTest.printVars(1,2,3,4,5)

    val a: Int = 1
    val b = 1
    val c: Int
    c = 1

    var x = 5
    x += 1


    //$
    //$varName
    //{$varName.fun()}
    var string = "x is $x"
    x = 2
    println(string)
    println("${string.replace("is", "was")}, but now is $string")

}
