package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("이름으로 자동차를 생성할 수 있다.")
    @Test
    void createCarByName() {
        // given
        String name = "car1";

        // when
        Car car = new Car(name);

        // then
        assertThat(car)
                .extracting("name", "position")
                .contains(name, 0);
    }

    @DisplayName("4 이상의 값으로 자동차를 움직일 수 있다.")
    @Test
    void attemptMoveWithGraterThanOrEqual4() {
        // given
        Car car = new Car("car1");

        // when
        car.attemptMove(4);

        // then
        assertThat(car).extracting("position").isEqualTo(1);
    }

    @DisplayName("4 미만의 값은 자동차를 움직일 수 없다.")
    @Test
    void attemptMoveWithLessThan4() {
        // given
        Car car = new Car("car1");

        // when
        car.attemptMove(3);

        // then
        assertThat(car).extracting("position").isEqualTo(0);
    }
}
