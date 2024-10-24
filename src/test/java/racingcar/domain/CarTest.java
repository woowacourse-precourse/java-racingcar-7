package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;

class CarTest {

    Car car;

    @BeforeEach
    void init() {
        car = new Car("pobi");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 전진(int value) {
        car.process(value);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void 정지(int value) {
        car.process(value);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}