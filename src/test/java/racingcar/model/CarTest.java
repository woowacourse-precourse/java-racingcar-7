package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 생성자_이름_초기화_테스트() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 생성자_거리_초기화_테스트() {
        assertThat(car.getMoveDistance()).isEqualTo(0);
    }
}
