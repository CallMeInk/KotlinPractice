package chapter08

fun perform(callback: (content: String) -> Int){
    println(callback("123"))
}

enum class Delivery{ STANSTARD, EXPEDITED}

class Order(val itemCount: Int)

class Test(){
    var test:Int = 1
}

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double{
    if (delivery == Delivery.EXPEDITED){
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return {order -> 1.2 * order.itemCount }
}

fun getNumber(): Int{
    println("in number")
    return 111
}

fun main(args: Array<String>) {
    var canReturnNull:(Int, Int) -> Int? = { x,y -> null }
    println(canReturnNull(1, 2))
    perform { content ->
        content.length
    }
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("it costs ${calculator(Order(5))}")
    var string: String? = null
    var test: Test? = null
    test?.test = getNumber()
    println(test?.test)
    val order = Order(1)
    //order.itemCount = 2
}
