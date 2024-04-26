package com.example.aplicativo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {

    private lateinit var btnUm: Button
    private lateinit var btnDois: Button
    private lateinit var btnContinuar: Button
    private lateinit var textoPergunta: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnContinuar = findViewById(R.id.btnContinuar)
        btnUm = findViewById(R.id.btnUm)
        btnDois = findViewById(R.id.btnDois)
        textoPergunta = findViewById(R.id.textoPergunta)

        btnUm.setOnClickListener {
            btnUm.setBackgroundColor(ContextCompat.getColor(this, R.color.Errado))
            textoPergunta.text = "QUE PENA, VOCÊ GASTOU TODO SEU DINHEIRO!"
            btnDois.isEnabled = false
        }

        btnDois.setOnClickListener {
            btnDois.setBackgroundColor(ContextCompat.getColor(this, R.color.Certo))
            textoPergunta.text = "PARABÉNS VOCÊ ECONOMIZOU!"
            btnUm.isEnabled = false
        }

        btnContinuar.setOnClickListener {
            val valorRecebido = intent.getIntExtra("pontos", 0)
            val valorSomado: Int = if (btnDois.isEnabled) 1 else 0
            val pontos = valorRecebido + valorSomado
            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("pontos", pontos)
            startActivity(intent)
        }
    }
}
