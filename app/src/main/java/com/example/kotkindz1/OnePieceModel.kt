package com.example.kotkindz1


class OnePieceModel:java.io.Serializable {
    constructor(url: String, name: String, age: Int, color: String)

    private var imageUrl: String? = null
    private var name: String? = null
    private var age:Int?=null
    private var color: String?=null


    fun getImageUrl(): String? {
        return imageUrl
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getAge(): Int {
        return age!!
    }

    fun getColor(): String? {
        return color
    }
}


