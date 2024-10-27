package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RaceCars;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceCarsTest {

    @Test
    void makeCarList_유효테스트() {
        List<String> carNames = List.of("Adam", "Ivan", "Harry");

        List<Car> cars = RaceCars.makeCarList(carNames);

        assertThat(cars).hasSize(3);
        assertThat(cars).extracting(Car::getCarName)
                .containsExactlyInAnyOrder("Adam", "Ivan", "Harry");
    }

}
