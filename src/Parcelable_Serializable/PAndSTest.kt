package Parcelable_Serializable

import java.io.*


class Client : Serializable{

    companion object {
        private val serialVersionUID = 1000000000L
    }

    var id: Int = 0
    var name: String = ""

}

fun main(args: Array<String>) {

    //把对象序列化到文件
    val client = Client()
    client.id = 1
    client.name = "client"

    val oo = ObjectOutputStream(FileOutputStream("/Users/yukai/IdeaProjects/KotlinPractice/src/Resource/cache.txt"))
    oo.writeObject(client)
    oo.close()

    //反序列化到内存
    val oi = ObjectInputStream(FileInputStream("/Users/yukai/IdeaProjects/KotlinPractice/src/Resource/cache.txt"))
    val c_back = oi.readObject() as Client
    println("Hi, My name is " + c_back.name)
    oi.close()
}
