package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingTest {

    private Racing racing;

    @Test
    void 우승자가_한명인_경우() {
        List<Car> cars = Arrays.asList(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );
        cars.get(0).move();
        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();
        racing = new Racing(cars);
        List<Car> winners = racing.getWinners();
        assertEquals(1, winners.size());
        assertEquals("pobi", winners.get(0).getName());
    }

    @Test
    void 우승자가_여러명인_경우() {
        List<Car> cars = Arrays.asList(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );
        cars.get(0).move();
        cars.get(0).move();
        cars.get(1).move();
        cars.get(1).move();
        cars.get(2).move();
        racing = new Racing(cars);
        List<Car> winners = racing.getWinners();
        assertEquals(2, winners.size());
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("pobi")));
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("woni")));
    }

}
