package com.example.missingseven.Model


data class ItemUiState(
    val iid: Int,
    val name: String,
    var quantity: Int,
    var price: Int,
    var img: Int,
    val strength: Float,
    val cleanedStrength: Float,
    val effectiveness: List<Float>,
    val cleanedEffectiveness: List<Float>
){
    fun isRubberBand() = iid == 4
}