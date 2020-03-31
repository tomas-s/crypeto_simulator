package sk.hilo.parser

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

class CsvParser : Parser{


override fun parse(): List<Line> {

    var lineList = listOf<Line>()
        csvReader().open("src/main/resources/Binance_BTCUSDT_1h.csv") {
             lineList = this.readAll().asReversed().map {
                 Line(it)
             }
        }
        return lineList
    }


}