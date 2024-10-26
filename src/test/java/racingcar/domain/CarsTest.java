package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void Cars_객체_생성() {
        List<Car> carList = List.of(new Car("pobi"), new Car("pobi"));
        Cars cars = new Cars(carList);
        assertThat(cars).isEqualTo(new Cars(carList));
    }
}
