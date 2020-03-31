package sk.hilo.parser

data class Line(
        val date: String,
        val symbol: String,
        val open: Double,
        val high: Double,
        val low: Double,
        val close: Double,
        val volumeBtc: Double,
        val volumeUsd: Double
) {

    constructor(list: List<String>) : this(list[0], list[1], list[2].toDouble(), list[3].toDouble(), list[4].toDouble(), list[5].toDouble(), list[6].toDouble(), list[7].toDouble())
}