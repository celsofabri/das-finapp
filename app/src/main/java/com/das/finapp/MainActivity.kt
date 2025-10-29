package com.das.finapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCadastro = findViewById<Button>(R.id.btnCadastro)
        val btnExtrato = findViewById<Button>(R.id.btnExtrato)
        val btnSair = findViewById<Button>(R.id.btnSair)

        btnCadastro.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        btnExtrato.setOnClickListener {
            val intent = Intent(this, ExtratoActivity::class.java)
            startActivity(intent)
        }

        btnSair.setOnClickListener {
            finishAffinity()
        }
    }
}
