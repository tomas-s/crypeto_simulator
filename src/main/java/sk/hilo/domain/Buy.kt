package sk.hilo.domain

import sk.hilo.domain.timeline.Hour

class Buy {
    constructor(period: Hour) {
        buyPeriod = period
        periods.add(period)
        statistics.put(periodIndex, BuyResult(buyPeriod.open, period.close, buyPeriod.volumeBtc, period.volumeBtc, period.close - buyPeriod.open))
    }

    private var buyPeriod: Hour
    private val maxPeriods: Int = 240
    private val periods: MutableList<Hour> = mutableListOf()
    val statistics = mutableMapOf<Int, BuyResult>()
    private var periodIndex: Int = 0


    fun nextPeriod(period: Hour) {
        periodIndex++
        if (periodIndex < maxPeriods) {
            periods.add(period)
            statistics.put(periodIndex, BuyResult(buyPeriod.open, period.close, buyPeriod.volumeBtc, period.volumeBtc, period.close - buyPeriod.open))
        }
    }

    fun getResult(): Map<Int, BuyResult> {
        periods.forEachIndexed { index, currentPeriod -> statistics.put(index, BuyResult(buyPeriod.open, currentPeriod.close, buyPeriod.volumeBtc, currentPeriod.volumeBtc, currentPeriod.close - buyPeriod.open)) }
        return statistics
    }
}