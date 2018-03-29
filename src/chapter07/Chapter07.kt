package chapter07

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

data class Point(val x: Int, val y: Int){
    operator fun plus(other: Point): Point{
        return Point(x + other.x, y + other.y)
    }
}

open class PropertyChangeAware{
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener){
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener){
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person(val name:String, age: Int, salary: Int) : PropertyChangeAware(){

    var age: Int = age
        set(value) {
            val oldValue = field
            field = value
            changeSupport.firePropertyChange("age", oldValue, value)
        }

    var salary: Int = salary
        set(value) {
            val oldValue = field
            field = value
            changeSupport.firePropertyChange("salary", oldValue, value)
        }

}

fun getString() = "getString"

class Person1(){
    val name by lazy { getString() }
}

fun main(args: Array<String>) {
    val point1 = Point(1, 2)
    val point2 = Point(3, 4)
    println(point1 + point2)
    var int1: Int = 1
    val int2: Int = 2
    int1 += int2
    int1 = int1 shl 2
    println("int1 = $int1")
    val p = Point(10, 20)
    val (x, y) = p
    println("x = $x, y = $y")
    val person = Person("Alice", 34, 2000)
    person.addPropertyChangeListener(PropertyChangeListener { evt: PropertyChangeEvent ->
        println("PropertyName :: ${evt.propertyName}  oldValue:: ${evt.oldValue}  newValue:: ${evt.newValue}")
    })
    person.age = 35
    person.salary = 3000
    println(Person1().name)
}
