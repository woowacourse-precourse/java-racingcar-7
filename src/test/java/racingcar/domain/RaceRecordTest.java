package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceRecordTest {

    @Test
    void 우승자_한명일경우() {
        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("woni", 3);
        Car car3 = new Car("jun", 3);

        car1.getReportCard().set(0, true);
        car1.getReportCard().set(1, true);
        car1.getReportCard().set(2, false);

        car2.getReportCard().set(0, true);
        car2.getReportCard().set(1, false);
        car2.getReportCard().set(2, false);

        car3.getReportCard().set(0, true);
        car3.getReportCard().set(1, true);
        car3.getReportCard().set(2, true);

        RaceRecord raceRecord = new RaceRecord(List.of(car1, car2, car3));

        List<String> winners = raceRecord.calculateWinners();

        assertEquals(1, winners.size());
        assertTrue(winners.contains("jun"));
    }

    @Test
    void 여러명이_우승자일_경우() {
        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("woni", 3);
        Car car3 = new Car("jun", 3);

        car1.getReportCard().set(0, true);
        car1.getReportCard().set(1, true);
        car1.getReportCard().set(2, true);

        car2.getReportCard().set(0, true);
        car2.getReportCard().set(1, true);
        car2.getReportCard().set(2, true);

        car3.getReportCard().set(0, true);
        car3.getReportCard().set(1, false);
        car3.getReportCard().set(2, true);

        RaceRecord raceRecord = new RaceRecord(List.of(car1, car2, car3));

        List<String> winners = raceRecord.calculateWinners();

        assertEquals(2, winners.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
    }
}
