package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("Jihyun");
    }

    @Test
    @DisplayName("[성공] 기준 숫자 이상이면 전진")
    void executeMove() {
        car.execute(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("[성공] 기준 숫자 미만이면 정지")
    void executeStay() {
        car.execute(0);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void testToString() {
    }

    @Test
    void compareTo() {
    }
}