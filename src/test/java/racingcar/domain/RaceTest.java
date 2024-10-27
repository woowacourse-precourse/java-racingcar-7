package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {


    private Car testCar (String carName) {
        Long oil = 1L;
        Engine engine = new Engine(1L, 1L);
        return new RacingCar(carName, oil, engine);
    }

    @Test
    @DisplayName("Race 생성 테스트")
    void createRace() {
        Long lap = 2L;
        List<Car> cars = List.of(testCar("test1"), testCar("test2"));
        Race race = new Race(lap, cars);

        assertEquals(lap, race.getLapLefts());
        assertEquals(cars, race.getEntry());
    }

    @Test
    @DisplayName("lap 차감 테스트")
    void lapClear() {
        Long lap = 2L;
        List<Car> cars = List.of(testCar("test1"), testCar("test2"));
        Race race = new Race(lap, cars);

        race.completeALap();

        Long expectedLap = lap - 1L;

        assertEquals(expectedLap, race.getLapLefts());
    }
}