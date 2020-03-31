package sk.hilo.domain.timeline

import sk.hilo.parser.Line
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Timeline {
    val hours: LinkedHashMap<LocalDateTime, Hour> = linkedMapOf()


    constructor(lineList: List<Line>) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-a")
        var currentLine: Line
        for (i in 1 until lineList.size) {
            val localDateTime = LocalDateTime.parse(lineList[i].date, formatter)
            currentLine = lineList[i]

            hours.put(localDateTime, Hour(
                    localDateTime,
                    currentLine.symbol,
                    currentLine.open,
                    currentLine.high,
                    currentLine.low,
                    currentLine.close,
                    currentLine.volumeBtc,
                    currentLine.volumeUsd
            ))
        }
    }

    fun getDataFromTo(from: LocalDateTime, to: LocalDateTime): Map<LocalDateTime, Hour> {
        return hours.filter { entry -> entry.key.isBefore(to) and (entry.key.isAfter(from)) }
    }


    fun getMax(): Hour? {
        return hours.values.maxBy { it.open }
    }

    fun getMin(): Hour? = hours.values.minBy { it.open }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Timeline

        if (hours != other.hours) return false

        return true
    }

    override fun hashCode(): Int {
        return hours.hashCode()
    }

    override fun toString(): String {
        return "Timeline(hours=$hours)"
    }


}