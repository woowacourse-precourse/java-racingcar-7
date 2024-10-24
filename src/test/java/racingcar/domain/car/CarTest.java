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
        Car car = new Car("Car");
        assertThat(car.getCarName()).isEqualTo("Car");
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void  carGoTest() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        car1.go(()-> true);
        assertThat(car1.getDistance()).isEqualTo(1);

        car2.go(()->false);
        assertThat(car2.getDistance()).isEqualTo(0);
    }

}