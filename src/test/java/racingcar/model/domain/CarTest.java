package racingcar.model.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름으로 객체를 생성하는 테스트")
    void createCarByName() {
        // given
        Car car = new Car("pobi");

        // when
        String carName = car.getCarName();

        // then
        assertThat(carName).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 객체 생성 시 초기 거리가 0인지 확인하는 테스트")
    void initialDistanceIsZero() {
        // given
        Car car = new Car("pobi");

        // when
        int currentDistance = car.getCurrentDistance();

        // then
        assertThat(currentDistance).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 조건에 따라 이동하여 거리가 0 또는 1인지 확인")
    void moveConditionally() {
        // given
        Car car = new Car("pobi");

        // when
        car.moveConditionally();

        // then
        assertThat(car.getCurrentDistance()).isBetween(0, 1);
    }
}