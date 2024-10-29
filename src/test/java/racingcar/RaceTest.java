package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceTest {

    private Race race;
    private List<Car> cars;

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
        cars = race.start();
        race.end(cars);
    }

    @Test
    public void raceFlow() {
        assertEquals(3, cars.size(), "자동차 수는 3이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void carNamesShouldExist(String carName) {
        assertTrue(cars.stream().anyMatch(car -> car.getName().equals(carName)),
                carName + "이 포함되어야 합니다.");
    }
}
