package com.das.finapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.text.NumberFormat
import java.util.Locale

class TransacaoAdapter(
    private val context: Context,
    private val transacoes: List<Transacao>
) : BaseAdapter() {

    private val currencyFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    override fun getCount(): Int = transacoes.size

    override fun getItem(position: Int): Any = transacoes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_transacao, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val transacao = transacoes[position]

        // Configurar tipo
        holder.tvTipo.text = if (transacao.tipo == Tipo.DEBITO) {
            context.getString(R.string.tipo_debito)
        } else {
            context.getString(R.string.tipo_credito)
        }

        // Configurar descrição
        holder.tvDescricao.text = transacao.descricao

        // Configurar valor com formatação e cor
        holder.tvValor.text = currencyFormat.format(transacao.valor)
        
        val colorRes = if (transacao.tipo == Tipo.DEBITO) {
            R.color.colorDebito
        } else {
            R.color.colorCredito
        }
        holder.tvValor.setTextColor(ContextCompat.getColor(context, colorRes))

        return view
    }

    private class ViewHolder(view: View) {
        val tvTipo: TextView = view.findViewById(R.id.tvTipo)
        val tvDescricao: TextView = view.findViewById(R.id.tvDescricao)
        val tvValor: TextView = view.findViewById(R.id.tvValor)
    }
}
