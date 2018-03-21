package chapter05

data class Person(val name: String, val age: Int)

fun findOldestPerson(people: List<Person>){
    var maxAge = -1
    var theOldest: Person? = null
    for (person in people){
        if (person.age > maxAge){
            maxAge = person.age
            theOldest = person
        }
    }
    println("the oldest::$theOldest")
}

class test{

    fun printSth(){
        run {::salute}
    }

}

data class Book(val title: String, val authors: List<String>)

fun alphabet() = with(StringBuilder()) {
    append("a")
    append("b")
    append("c")
    toString()
}

fun alphabet1(): String = StringBuilder().apply{
    append("a")
    append("b")
    append("c")
}.toString()

fun main(args: Array<String>) {
    val personList = listOf(Person("Alice", 16), Person("Bob", 18))
    findOldestPerson(personList)
    println(personList.maxBy { it.age })
    run { println("lambda")}
    val sum = {x: Int, y: Int ->
        println("lambda expression")
        x + y
    }
    val sum1 = sum(1, 2)
    println(sum1)
    val getAge1 = Person::age
    val getAge2 = {p: Person -> p.age}
    println(getAge1(Person("alice", 18)))
    println(getAge2(Person("alice", 18)))
    println(personList.filter { it.age > 17 && it.name.length < 10 })
    val list = listOf(1, 2, 3, 4)
    println(list.map { it + 1 })
    println(list)
    val maxAge = personList.maxBy(Person::age)?.age
    println("maxAge::$maxAge")
    val numbersMap = mapOf(0 to "zero", 1 to "one")
    println(numbersMap.mapValues { it.value.toUpperCase() })
    val books = listOf(Book("book1", listOf("Alice", "Bob")),
            Book("book2", listOf("Cat", "Bob")))
    println(books.flatMap { it.authors })
    println("*****start*****")
    listOf(1, 2, 3, 4).asSequence()
            .map { println("map($it)"); it * it }
            .filter { println("filter($it)"); it % 2 == 0 }
    println("*****start*****")
    listOf(1, 2, 3, 4).asSequence()
            .map { println("map($it)"); it * it }
            .filter { println("filter($it)"); it % 2 == 0 }
            .toList()
    println(listOf(1, 3, 5, 7).asSequence().map { it * it }.find { it > 4 })
    println(listOf(1, 3, 5, 7).map { it * it }.find { it > 4 })



}