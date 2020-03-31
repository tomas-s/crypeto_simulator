package sk.hilo

import sk.hilo.domain.Buy
import sk.hilo.domain.Trend
import sk.hilo.domain.timeline.Hour
import sk.hilo.domain.timeline.Timeline
import java.time.LocalDateTime

//TODO: Buy conditions
class Simulator(
        private val timeline: Timeline,
        private val buyLimit: Int = -5 //percentage
) {

    var trend: Trend = Trend()
    val buys = mutableListOf<Buy>()

    fun startSimulation(): MutableList<Buy> {
        val iterator = timeline.hours.toList().listIterator()
        simulate(iterator)
        return buys
    }

    fun startSimulationFromTo(from: LocalDateTime, to: LocalDateTime): MutableList<Buy> {
        val iterator = timeline.getDataFromTo(from, to).toList().listIterator()
        simulate(iterator = iterator)
        return buys
    }

    private fun simulate(iterator: ListIterator<Pair<LocalDateTime, Hour>>) {
        while (iterator.hasNext()) {
            val currentPeriod = iterator.next().second
            buys.forEach { it.nextPeriod(currentPeriod) }
            trend.nextPeriod(currentPeriod.open, currentPeriod.close)
            if (trend.getTrendChange() < buyLimit) {
                buys.add(Buy(currentPeriod))
            }
        }
    }

}