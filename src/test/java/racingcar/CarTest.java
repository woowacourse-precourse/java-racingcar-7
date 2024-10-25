package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.Car;
import racingcar.domain.model.value.Distance;

class CarTest {


    @DisplayName("자동차가 전진하면 자동차의 거리가 1 증가한다")
    @Test
    void carFunctionTest() {

        // given
        Car car = Car.create("khan");

        // when
        car.go(() -> true);

        // then
        Assertions.assertThat(car.getDistance()).isEqualTo(new Distance(1));
    }
}
