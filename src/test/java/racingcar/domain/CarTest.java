package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Test");
    }

    @Test
    void 생성_테스트() {
        assertThat(car.getName()).isEqualTo("Test");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 전진_테스트() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 여러번_전진_테스트() {
        car.move();
        car.move();
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);
    }
}