package sk.hilo

import org.junit.Test

import sk.hilo.domain.timeline.Timeline
import sk.hilo.parser.CsvParser
import java.time.format.DateTimeFormatter

class SimulatorTest {

    var timeline: Timeline = Timeline(CsvParser().parse())
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-a")
    val simulator = Simulator(timeline)

    @Test
    fun startSimulation() {
        simulator.startSimulation()
    }

    @Test
    fun startSimulationFromTo() {
    }
}