package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 자동차_이름_설정() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_초기_위치() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이동_성공() {
        int newPosition = car.move(4);
        assertThat(newPosition).isEqualTo(4);
        assertThat(car.getPosition()).isEqualTo(4);
    }

    @Test
    void 이동_실패() {
        int newPosition = car.move(3);
        assertThat(newPosition).isEqualTo(0);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 여러_번_이동() {
        car.move(4);
        car.move(5);
        car.move(3);

        assertThat(car.getPosition()).isEqualTo(9);
    }
}
