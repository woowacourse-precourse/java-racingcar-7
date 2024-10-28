package racingcar.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceHistoryTest {
    RaceHistory raceHistory;

    @BeforeEach
    void setUp() {
        raceHistory = new RaceHistory();
    }

    @Test
    void addRound() {
        // given
        List<Car> cars = List.of(new Car("a"), new Car("b"));

        // when
        raceHistory.addRound(cars);

        // then
        Map<String, Integer> round = raceHistory.getRound(0);
        assertEquals(2, round.size());
        assertEquals(0, round.get("a"));
    }

    @Test
    void addRoundCarMoved() {
        // given
        List<Car> cars = List.of(new Car("a"), new Car("b"));
        cars.getFirst().move(4);

        // when
        raceHistory.addRound(cars);

        // then
        Map<String, Integer> round = raceHistory.getRound(0);
        assertEquals(2, round.size());
        assertEquals(1, round.get("a"));
        assertEquals(0, round.get("b"));
    }
}