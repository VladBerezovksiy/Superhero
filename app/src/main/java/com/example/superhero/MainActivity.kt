package com.example.superhero

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
    }
}

data class Superhero(val name: String, val images: Images, val work: Works)
data class Works(val occupation: String)
data class Images(val xs: String)