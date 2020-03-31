package sk.hilo

import sk.hilo.domain.timeline.Timeline
import sk.hilo.parser.CsvParser
import sk.hilo.parser.Parser
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//data from https://www.cryptodatadownload.com/data/binance/
fun main() {
    val parser: Parser = CsvParser()

    println("Start parsing!")

    val lineList = parser.parse()

    val timeline = Timeline(lineList)
    println("tostring $timeline")

    println(timeline.getMax())
    println(timeline.getMin())

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-a")
    val from = LocalDateTime.parse("2019-03-19 07-PM", formatter)
    val to = LocalDateTime.parse("2019-03-22 07-PM", formatter)
    println("from - to")
    println(timeline.getDataFromTo(from, to))


}

