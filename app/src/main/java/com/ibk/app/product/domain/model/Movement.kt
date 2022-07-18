package com.ibk.app.product.domain.model


data class Movement(
    var id: Int,
    var destination: String,
    var isMoneyIncome: Boolean,
    var date: String,
    var amount: String
)