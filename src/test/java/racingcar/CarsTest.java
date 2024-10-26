package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.Cars;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    @Test
    void 자동차들_객체_생성한다() {
        List<String> names = List.of("pobi", "woni");
        Cars cars = Cars.from(names);
        assertEquals(names, cars.getNames());
    }

    @Test
    void 첫_번째_차는_멈추고_두_번째_차는_움직인다() {
        List<String> names = List.of("pobi", "woni");
        Cars cars = Cars.from(names, new TestNumberGenerator(List.of(3, 4)));

        Cars movedCars = cars.moveForward();

        assertEquals(List.of(0, 1), movedCars.getPositions());
    }

    @Test
    void 우승자를_찾는다() {
        List<String> names = List.of("pobi", "woni", "jun");
        Cars cars = Cars.from(names, new TestNumberGenerator(List.of(4, 4, 3, 4, 4, 3, 4, 4, 3)));

        Cars finalCars = cars.moveForward()
                .moveForward()
                .moveForward();
        List<String> winners = finalCars.findWinners();

        assertEquals(List.of("pobi", "woni"), winners);
    }
}
