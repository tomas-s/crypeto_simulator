package sk.hilo.domain

class Trend {

    var trendEnum = TrendEnum.NONE
    var valueAtTrendChange: Double = 0.0
    var lastClose: Double = 0.0
    var balance = 0.0

    fun nextPeriod(open: Double, close: Double) {
        lastClose = close
        balance = close - open
        when {
            balance < 0.0 && trendEnum != TrendEnum.RECESSION -> {
                trendEnum = TrendEnum.RECESSION
                valueAtTrendChange = open
            }
            balance > 0.0 && trendEnum != TrendEnum.EXPANSION -> {
                trendEnum = TrendEnum.EXPANSION
                valueAtTrendChange = open
            }
            balance == 0.0 && trendEnum != TrendEnum.NONE -> {
                trendEnum = TrendEnum.NONE
                valueAtTrendChange = open
            }
        }

    }

    /**
     * return trend change in percentage
     */
    fun getTrendChange(): Double {
        val trendChange = 100 - (lastClose / (valueAtTrendChange / 100))
        return trendChange
    }


}