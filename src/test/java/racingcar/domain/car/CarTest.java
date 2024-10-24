package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 저장 및 조회 테스트")
    void carBasicTest() {
        Car car = new Car("Tom");
        assertThat(car.getCarName()).isEqualTo("Tom");
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void  carGoTest() {
        Car car = new Car("Tom");
        car.go(()-> true);
        assertThat(car.getDistance()).isEqualTo(1);
    }

}