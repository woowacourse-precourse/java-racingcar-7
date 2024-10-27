package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarFactoryTest {

    @Test
    void 자동차를_생성한다() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");

        // when
        List<Car> cars = CarFactory.generateCars(carNames);

        // then
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
    }

}