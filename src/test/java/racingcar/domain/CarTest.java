package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차가_정상적으로_전진하는가(int random) {
        Car car = new Car("pobi");
        car.move(random);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차가_정상적으로_멈춰있는가(int random) {
        Car car = new Car("pobi");
        car.move(random);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
