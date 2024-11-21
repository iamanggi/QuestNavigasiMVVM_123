package com.example.praktikum6.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormulirView(
    modifier: Modifier = Modifier.padding(vertical = 50.dp),
    listJk: List<String>,
    //untuk menghendel onclick diparameter
    onSubmitClicked: (MutableList<String>) -> Unit){

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    //susunannya harus sama agar data yang disimpan tidak tertukar
    val listData: MutableList<String> = mutableListOf(nama, gender, alamat, email, notelepon)

    Column(modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "isi nama anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        Row (modifier = Modifier.fillMaxWidth()){
            listJk.forEach{selectedGender ->
                Row (
                    verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = { gender = selectedGender
                        }
                    )
                    Text(text = selectedGender)

                }}
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "isi email anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text(text = "isi alamat anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = {
                Text(text = "No Telepon")
            },
            placeholder = {
                Text(text = "isi No telepon anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        //menambahkan event onClick untuk menyimpan data di model
        Button(onClick = {
            onSubmitClicked(listData) //sebuah parameter dan fungsi onClick akan diwakili oleh onSubmitClicked
        }, modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp)) {
            Text(text = "Simpan".uppercase(), fontSize = 18.sp)

        }

    }
}

