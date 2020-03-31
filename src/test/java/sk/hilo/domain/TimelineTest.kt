package sk.hilo.domain

import org.junit.Assert
import org.junit.Assert.assertNotEquals
import org.junit.Test
import sk.hilo.domain.timeline.Timeline
import sk.hilo.parser.CsvParser
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TimelineTest {

    var timeline: Timeline = Timeline(CsvParser().parse())
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-a")


    @Test
    fun getEventsFromTo() {
        val from = LocalDateTime.parse("2019-03-19 07-PM", formatter)
        val to = LocalDateTime.parse("2019-03-22 07-PM", formatter)
        assertNotEquals(0, timeline.getDataFromTo(from, to).size)
    }

    @Test
    fun getMax() {
        assertNotEquals(0, timeline.getMax()?.open?:0)
    }

    @Test
    fun getMin() {
        assertNotEquals(0, timeline.getMin()?.open?:0)
    }

    @Test
    fun getAllEvents(){
        val events = timeline.hours
        Assert.assertTrue(events.isNotEmpty())
    }
}