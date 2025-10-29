package com.das.finapp

import java.math.BigDecimal

data class Transacao(
    val tipo: Tipo,
    val descricao: String,
    val valor: BigDecimal
)
