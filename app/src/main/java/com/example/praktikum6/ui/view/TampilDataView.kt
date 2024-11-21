package com.example.praktikum6.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum6.model.DataSiswa

@Composable
fun TampilDataView(
    uiState: DataSiswa,
    onBackButton: ()-> Unit

){
    Column (modifier = Modifier.fillMaxSize().padding(vertical = 50.dp, horizontal = 16.dp)){
        TampilData(param = "Nama", argum = uiState.nama)
        TampilData(param = "Jenis Kelamin", argum = uiState.gender)
        TampilData(param = "Alamat", argum = uiState.alamat)
        TampilData(param = "Email", argum = uiState.email)
        TampilData(param = "No Telepon", argum = uiState.noTel)
        Button(onClick = onBackButton, modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp)) {
            Text(text = "Kembali".uppercase(), fontSize = 18.sp)
        }
    }
}
@Composable
fun TampilData(
    param: String, argum: String
) {
    Box(modifier = Modifier.background(color = Color.LightGray)) {
        Column(
            modifier = Modifier.padding(16.dp)
        )
        {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Text(
                    text = param,
                    modifier = Modifier.weight(0.8f)
                ) // memberi ruang seberapa banyak dalam kolon/barisnya
                Text(
                    text = ":",
                    modifier = Modifier.weight(0.2f)
                )
                Text(
                    text = argum, //kenapa argum? karena isinya akan digantikan dengan parameter argum
                    modifier = Modifier.weight(2f)
                )

            }
        }
    }
}
