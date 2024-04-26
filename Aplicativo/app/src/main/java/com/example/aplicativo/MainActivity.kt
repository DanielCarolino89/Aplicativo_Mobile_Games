package com.example.aplicativo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnJogar: Button
    private lateinit var btnJogar2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnJogar = findViewById(R.id.btnJogar)
        btnJogar2 = findViewById(R.id.btnJogar2)

        btnJogar.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }

        btnJogar2.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity7::class.java)
            startActivity(intent)
        }
    }
}