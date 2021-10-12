package ch.tutteli.atrium.api.fluent.en_GB.samples

import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.internal.expect
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.Month
import kotlin.test.Test

class LocalDateTimeExpectationSamples {

    @Test
    fun yearFeature() {
        expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
            .year.toEqual(2021)
        //  | subject is now of type Int

        fails {
            expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
                .year.notToEqual(2021)
            //  | subject is now of type Int
        }
    }

    @Test
    fun year() {
        expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
            .year {
                // subject inside this block is of type Int (actually 2021)
                toEqual(2021)
                toBeGreaterThan(2020)
            } // subject here is back to type LocalDateTime

        fails {
            expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
                .year {
                    // subject inside this block is of type Int (actually 2021)
                    notToEqual(2021)
                    toBeGreaterThan(2022)
                    toBeLessThan(2020)
                } // subject here is back to type LocalDateTime
        }
    }

    @Test
    fun monthFeature() {
        expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
            .month.toEqual(Month.OCTOBER.value)
        //  | subject is now of type Int

        fails {
            expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
                .month.toEqual(Month.SEPTEMBER.value)
            //  | subject is now of type Int
        }
    }

    @Test
    fun month() {
        expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
            .month {
                // subject inside this block is of type Int (actually Month.OCTOBER.value i.e. 10)
                toEqual(Month.OCTOBER.value)
                notToEqual(Month.SEPTEMBER.value)
            } // subject here is back to type LocalDateTime

        fails {
            expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
                .month {
                    // subject inside this block is of type Int (actually Month.OCTOBER.value i.e. 10)
                    toEqual(Month.SEPTEMBER.value)
                    notToEqual(Month.OCTOBER.value)
                } // subject here is back to type LocalDateTime
        }
    }

    @Test
    fun dayOfWeekFeature() {
        expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
            .dayOfWeek.toEqual(DayOfWeek.SATURDAY)
        //  | subject is now of type DayOfWeek

        fails {
            expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
                .dayOfWeek.toEqual(DayOfWeek.MONDAY)
            //  | subject is now of type DayOfWeek
        }
    }

    @Test
    fun dayOfWeek() {
        expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
            .dayOfWeek {
                // subject inside this block is of type DayOfWeek (actually SATURDAY)
                toEqual(DayOfWeek.SATURDAY)
                notToEqual(DayOfWeek.SUNDAY)
            } // subject here is back to type LocalDateTime

        fails {
            expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
                .dayOfWeek {
                    // subject inside this block is of type DayOfWeek (actually SATURDAY)
                    toEqual(DayOfWeek.MONDAY)
                    notToEqual(DayOfWeek.SATURDAY)
                } // subject here is back to type LocalDateTime
        }
    }

    @Test
    fun dayFeature() {
        expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
            .day.toEqual(9)
        //  | subject is now of type Int

        fails {
            expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
                .day.toEqual(5)
            //  | subject is now of type Int
        }
    }

    @Test
    fun day() {
        expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
            .day {
                // subject inside this block is of type Int (actually 9)
                toEqual(9)
                toBeGreaterThan(5)
            } // subject here is back to type LocalDateTime

        fails {
            expect(LocalDateTime.of(2021, Month.OCTOBER, 9, 11, 56))
                .day {
                    // subject inside this block is of type Int (actually 9)
                    toEqual(5)
                    toBeLessThan(7)
                } // subject here is back to type LocalDateTime
        }
    }
}
