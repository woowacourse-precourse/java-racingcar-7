package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WinnerTest {

    @Test
    void 우승자_한명() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        car1.race(true);
        car2.race(false);
        car3.race(false);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        List<Car> winners = Winner.getWinners(cars);

        assertThat(winners).containsExactly(car1);
    }

    @Test
    void 우승자가_여러명() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        car1.race(true);
        car2.race(true);
        car3.race(false);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        List<Car> winners = Winner.getWinners(cars);

        assertThat(winners).containsExactlyInAnyOrder(car1, car2);
    }
}