package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"woowahan", "course", "racingcar"})
    void 자동차_이름이_최대_길이를_넘긴_경우_예외(String carName) {
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

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
