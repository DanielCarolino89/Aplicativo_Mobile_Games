package com.example.aplicativo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity6 : AppCompatActivity() {

    private lateinit var btnContinuar: Button
    private lateinit var textoPergunta: TextView
    private lateinit var imgPrincipal: ImageView

    @SuppressLint("MissingInflatedId", "SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnContinuar = findViewById(R.id.btnContinuar)
        textoPergunta = findViewById(R.id.textoPergunta)
        imgPrincipal = findViewById(R.id.imgPrincipal)

        verificar()

        btnContinuar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun verificar(){
        val pontosRecebidos = intent.getIntExtra("pontos", 0)
        if (pontosRecebidos < 3){
            textoPergunta.text = "Precisa melhorar, gaste menos dinheiro"
            imgPrincipal.setImageResource(R.drawable.bravo)
        }else if(pontosRecebidos == 3){
            textoPergunta.text = "Está bom, mas pode melhorar"
            imgPrincipal.setImageResource(R.drawable.triste)
        }else{
            textoPergunta.text = "Parabéns, você é um grande economista!"
            imgPrincipal.setImageResource(R.drawable.rico)
        }
}
}
