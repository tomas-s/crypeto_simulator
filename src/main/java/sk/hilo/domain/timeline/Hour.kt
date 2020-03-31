package sk.hilo.domain.timeline

import java.time.LocalDateTime

data class Hour (
        val date: LocalDateTime,
        val symbol: String,
        val open: Double,
        val high: Double,
        val low: Double,
        val close: Double,
        val volumeBtc: Double,
        val volumeUsd: Double
){
    fun getBalance() = close - open
}