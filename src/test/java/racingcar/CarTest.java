package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void 이동_횟수_확인() {
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 자동차_이름_확인() {
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    void 자동차_이동() {
        for (int i = 0; i < 5; i++) {
            car.move();
        }
        assertThat(car.getMoveCount()).isEqualTo(5);
    }
}