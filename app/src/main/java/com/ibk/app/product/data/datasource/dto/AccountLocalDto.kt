package com.ibk.app.product.data.datasource.dto

data class AccountLocalDto(
    var id: Int,
    var type: String,
    var amount: String,
    var number: String,
    var movements: List<MovementLocalDto>? = null
) {
    fun getDisplayAccount(): String = "Cuenta $type"
}