package com.example.testweatherapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testweatherapp.network.IpApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CoroutineScope(Dispatchers.IO).launch {
                try {
                    val listResult = IpApi.retrofitService.getCurrentLocation()
                    fun Context.toast() = Toast.makeText(this, "${listResult.city}", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    fun Context.toast() = Toast.makeText(this, "${e}", Toast.LENGTH_SHORT).show()
                }
        }

    }
}