package com.example.praktikum6.viewmodel

import androidx.lifecycle.ViewModel
import com.example.praktikum6.model.DataSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {
//jika variabel diawali dengan _ (underscore) maka datanya hanya bisa diakses sendiri
    //status UI menyimpan data model yaitu data siswa (Request)

    private val _statusUI = MutableStateFlow(DataSiswa())

    //status UI yang tidak privet digunakan untuk akses view (Response)
    val statusUI: StateFlow<DataSiswa> = _statusUI.asStateFlow()

    //mempunyai parameter berupa list
    fun saveDataSiswa(ls : MutableList<String>) {

        //status saat ini isinya adalah sebuah model yang diperbarui adalah nama, gender, alamat, email, no telepon
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0], //ls 0,1,2 didapatkan dari UI
                gender = ls[1],
                alamat = ls[2],
                email = ls[3],
                noTel = ls[4])
        }
    }

}