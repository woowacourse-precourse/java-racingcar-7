package racingcar.model.race;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.AlwaysMoveStrategy;
import racingcar.model.car.Car;

public class RaceTest {
    @Test
    @DisplayName("자동차들이 이동 조건에 따라 전진한다")
    void shouldMoveCarsCorrectly() {
        List<Car> cars = List.of(
                new Car("Car1", new AlwaysMoveStrategy()),
                new Car("Car2", () -> false)
        );
        Race race = new Race(cars);
        race.moveCars();
        assertEquals(1, cars.get(0).getPosition());
        assertEquals(0, cars.get(1).getPosition());
    }

    @Test
    @DisplayName("우승자를 올바르게 결정한다")
    void shouldDetermineWinnersCorrectly() {
        List<Car> cars = List.of(
                new Car("Car1", new AlwaysMoveStrategy()),
                new Car("Car2", new AlwaysMoveStrategy())
        );
        Race race = new Race(cars);
        cars.getFirst().move();
        race.moveCars();
        List<String> winners = race.getWinners();
        assertEquals(List.of("Car1"), winners);
    }
}
