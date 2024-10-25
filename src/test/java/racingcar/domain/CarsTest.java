package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 생성() {
        List<Car> carList = List.of(new Car("pobi"), new Car("woni"));
        assertThat(new Cars(carList)).isEqualTo(new Cars(carList));
    }

    @Test
    void 우승자_한_명_찾기() {
        List<Car> carList = List.of(
                new Car("pobi", 1),
                new Car("woni", 1),
                new Car("jun", 2)
        );

        Cars cars = new Cars(carList);

        List<String> winners = List.of("jun");

        assertThat(cars.findWinners()).isEqualTo(winners);
    }

    @Test
    void 우승자_여러_명_찾기() {
        List<Car> carList = List.of(
                new Car("pobi", 3),
                new Car("woni", 3),
                new Car("jun", 3)
        );

        Cars cars = new Cars(carList);

        List<String> winners = List.of("pobi", "woni", "jun");

        assertThat(cars.findWinners()).isEqualTo(winners);
    }

    @Test
    void to_string() {
        List<Car> carList = List.of(new Car("pobi", 1),
                new Car("woni", 3),
                new Car("jun", 3)
        );
        Cars cars = new Cars(carList);

        assertThat(cars.toString()).isEqualTo("pobi : -\nwoni : ---\njun : ---\n");
    }

}
