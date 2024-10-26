package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 이동_횟수_확인() {
        Car car = new Car("test");
        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}