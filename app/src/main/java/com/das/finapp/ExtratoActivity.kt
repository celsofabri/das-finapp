package com.das.finapp

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExtratoActivity : AppCompatActivity() {

    private lateinit var lvTransacoes: ListView
    private lateinit var tvEmpty: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extrato)

        lvTransacoes = findViewById(R.id.lvTransacoes)
        tvEmpty = findViewById(R.id.tvEmpty)

        carregarTransacoes()
    }

    override fun onResume() {
        super.onResume()
        carregarTransacoes()
    }

    private fun carregarTransacoes() {
        val transacoes = TransacoesRepo.itens

        if (transacoes.isEmpty()) {
            lvTransacoes.visibility = View.GONE
            tvEmpty.visibility = View.VISIBLE
        } else {
            lvTransacoes.visibility = View.VISIBLE
            tvEmpty.visibility = View.GONE

            val adapter = TransacaoAdapter(this, transacoes)
            lvTransacoes.adapter = adapter
        }
    }
}
