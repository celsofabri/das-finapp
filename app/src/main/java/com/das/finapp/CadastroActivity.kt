package com.das.finapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        // Configurar formatação de entrada de moeda
        setupCurrencyInputMask()
    }

    /**
     * Configura o TextWatcher para formatar a entrada de valor monetário
     * Permite vírgula como separador decimal
     */
    private fun setupCurrencyInputMask() {
        etValor.addTextChangedListener(object : TextWatcher {
            private var isUpdating = false

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isUpdating) return

                isUpdating = true
                
                val text = s.toString()
                
                // Permitir apenas números, vírgula e ponto
                val filtered = text.filter { it.isDigit() || it == ',' || it == '.' }
                
                // Garantir apenas um separador decimal (vírgula ou ponto)
                val commaCount = filtered.count { it == ',' }
                val dotCount = filtered.count { it == '.' }
                
                if (commaCount > 1 || dotCount > 1 || (commaCount > 0 && dotCount > 0)) {
                    // Remover separadores extras
                    val firstSeparatorIndex = filtered.indexOfFirst { it == ',' || it == '.' }
                    if (firstSeparatorIndex >= 0) {
                        val cleaned = filtered.filterIndexed { index, c ->
                            c != ',' && c != '.' || index == firstSeparatorIndex
                        }
                        s?.replace(0, s.length, cleaned)
                    }
                } else if (filtered != text) {
                    s?.replace(0, s.length, filtered)
                }
                
                isUpdating = false
            }
        })
    }

    /**
     * Faz o parse de um valor monetário para BigDecimal
     * Aceita vírgula ou ponto como separador decimal
     * @param input String com o valor a ser parseado
     * @return BigDecimal ou null se o parse falhar
     */
    private fun parseCurrencyValue(input: String): BigDecimal? {
        return try {
            val normalized = input.trim().replace(",", ".")
            BigDecimal(normalized)
        } catch (e: NumberFormatException) {
            null
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

        val valor = parseCurrencyValue(valorStr)
        if (valor == null) {
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
