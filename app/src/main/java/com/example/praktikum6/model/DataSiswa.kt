package com.example.praktikum6.model

data class DataSiswa(
    //karena mau dibuat properti didalam data class
    //kenapa val? karena umumnya datanya 1
    val nama: String = " ",
    val alamat: String = " ",
    val gender: String = " ",
    val email: String = "",
    val noTel: String="",

)
