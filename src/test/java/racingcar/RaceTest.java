package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        InputHandler inputHandler = new InputHandler() {
            @Override
            public List<Car> carList() {
                return List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
            }

            @Override
            public int tryCount() {
                return 3;
            }
        };

        OutputHandler outputHandler = new OutputHandler() {
            @Override
            public void printResults(List<Car> cars) {
            }

            @Override
            public void printWinners(List<Car> winners) {
            }
        };

        race = new Race(inputHandler, outputHandler);
    }

    @Test
    public void raceFlow() {
        List<Car> cars = race.startRace();

        race.endRace(cars);

        assertEquals(3, cars.size(), "자동차 수는 3이어야 합니다.");
        assertTrue(cars.stream().anyMatch(car -> car.getName().equals("pobi")), "pobi가 포함되어야 합니다.");
        assertTrue(cars.stream().anyMatch(car -> car.getName().equals("woni")), "woni가 포함되어야 합니다.");
        assertTrue(cars.stream().anyMatch(car -> car.getName().equals("jun")), "jun이 포함되어야 합니다.");
    }
}
