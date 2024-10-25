package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차가_정상적으로_전진하는가(int random) {
        Car car = new Car("pobi");
        // assertThat(car.move()).isTrue();
        car.move();
        assertThat(car.position()).isEqualsTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차가_정상적으로_멈춰있는가() {
        Car car = new Car("pobi");
        // assertThat(car.move()).isFalse();
        car.move();
        assertThat(car.position()).isEqualsTo(0);
    }
}
