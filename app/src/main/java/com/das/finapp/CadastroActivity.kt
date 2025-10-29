package com.das.finapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class CadastroActivity : AppCompatActivity() {

    private lateinit var rgTipo: RadioGroup
    private lateinit var rbDebito: RadioButton
    private lateinit var rbCredito: RadioButton
    private lateinit var etDescricao: EditText
    private lateinit var etValor: EditText
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // Inicializar views
        rgTipo = findViewById(R.id.rgTipo)
        rbDebito = findViewById(R.id.rbDebito)
        rbCredito = findViewById(R.id.rbCredito)
        etDescricao = findViewById(R.id.etDescricao)
        etValor = findViewById(R.id.etValor)
        btnSalvar = findViewById(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            salvarTransacao()
        }
    }

    private fun salvarTransacao() {
        val descricao = etDescricao.text.toString().trim()
        val valorStr = etValor.text.toString().trim()

        // Validações
        if (descricao.isEmpty()) {
            Toast.makeText(this, R.string.msg_erro_descricao, Toast.LENGTH_SHORT).show()
            return
        }

        if (valorStr.isEmpty()) {
            Toast.makeText(this, R.string.msg_erro_valor, Toast.LENGTH_SHORT).show()
            return
        }

        val valor = try {
            BigDecimal(valorStr)
        } catch (e: NumberFormatException) {
            Toast.makeText(this, R.string.msg_erro_valor, Toast.LENGTH_SHORT).show()
            return
        }

        if (valor <= BigDecimal.ZERO) {
            Toast.makeText(this, R.string.msg_erro_valor, Toast.LENGTH_SHORT).show()
            return
        }

        // Determinar tipo
        val tipo = if (rbDebito.isChecked) Tipo.DEBITO else Tipo.CREDITO

        // Criar e salvar transação
        val transacao = Transacao(tipo, descricao, valor)
        TransacoesRepo.itens.add(transacao)

        Toast.makeText(this, R.string.msg_sucesso, Toast.LENGTH_SHORT).show()
        finish()
    }
}
