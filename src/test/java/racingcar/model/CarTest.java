package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private static final int FORWARDING_TEST = 1;
    private static final int FORWARD_RANDOM_NUM = 5; // 무작위 값이 4이상인 수
    private static final int STOPPING_TEST = 0;
    private static final int STOP_RANDOM_NUM = 3; // 무작위 값이 4미만인 수

    private Car car;

    @BeforeEach
    void init() {
        car = new Car("TestCar");
    }

    @DisplayName("무작위 값이 4이상일 경우 전진하기")
    @Test
    void 전진_테스트() {
        car.move(FORWARD_RANDOM_NUM);
        assertThat(car.getPosition()).isEqualTo(FORWARDING_TEST);
    }

    @DisplayName("무작위 값이 4미만일 경우 멈추기")
    @Test
    void 멈춤_테스트() {
        car.move(STOP_RANDOM_NUM);
        assertThat(car.getPosition()).isEqualTo(STOPPING_TEST);
    }

    @AfterEach
    void close() {
        car = null;
    }
}
