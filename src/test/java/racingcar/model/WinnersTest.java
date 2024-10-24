package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    @Test
    void 단일_우승자를_제대로_찾는지_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 2));
        cars.add(new Car("woni", 1));
        cars.add(new Car("jun", 0));

        List<Car> winners = Winners.findWinner(cars);

        assertThat(winners).contains(new Car("pobi", 2));
    }
}
