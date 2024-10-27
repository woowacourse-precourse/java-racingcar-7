package racingcar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.model.ModelTestConstants.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar",0);
    }

    @DisplayName("무작위 값이 4이상일 경우 전진하기")
    @Test
    void 전진_테스트() {
        car.move(FORWARD_RANDOM_NUM.getValue());
        assertThat(car.getPosition()).isEqualTo(FORWARDING_TEST.getValue());
    }

    @DisplayName("무작위 값이 4미만일 경우 멈추기")
    @Test
    void 멈춤_테스트() {
        car.move(STOP_RANDOM_NUM.getValue());
        assertThat(car.getPosition()).isEqualTo(STOPPING_TEST.getValue());
    }

    @AfterEach
    void tearDown() {
        car = null;
    }
}
