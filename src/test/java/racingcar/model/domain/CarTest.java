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
}