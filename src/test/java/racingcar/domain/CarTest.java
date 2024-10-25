package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차가 이름으로 동등성이 비교되는 테스트")
    void car_Test1() {
        Car genesis1 = new Car("제네시스");
        Car genesis2 = new Car("제네시스");
        assertThat(genesis1.equals(genesis2)).isEqualTo(true);
        assertThat(genesis1.hashCode() == genesis2.hashCode()).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차가 전진하는 테스트")
    void car_Test2() {
        Car car = new Car("전진하는 자동차");
        car.forward();
        assertThat(car.getCarPosition()).isEqualTo(1);
    }
}