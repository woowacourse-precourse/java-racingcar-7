package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private static final int STANDARD_NUMBER = 4;
    private Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("test");
    }

    @Test
    void 전진_테스트() {
        car.go(STANDARD_NUMBER);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지_테스트() {
        car.go(STANDARD_NUMBER - 1);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_출력_테스트() {
        car.go(STANDARD_NUMBER);
        car.go(STANDARD_NUMBER);
        assertThat(car.toString()).isEqualTo("test : --");
    }
}