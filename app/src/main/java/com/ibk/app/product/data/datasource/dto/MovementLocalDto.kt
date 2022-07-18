package com.ibk.app.product.data.datasource.dto



data class MovementLocalDto(
    var id: Int,
    var destination: String,
    var isMoneyIncome: Boolean,
    var date: String,
    var amount: String
)
