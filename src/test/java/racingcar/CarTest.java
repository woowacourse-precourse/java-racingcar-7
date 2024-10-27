package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarTest {

    @Test
    @DisplayName("무작위값이 4 이상인 경우 distance 값을 하나 증가시킨다")
    void moveOrStop() {
        Car car = new Car("test");

        for (int i = 0; i < 4; i++) {
            car.moveOrStop(i);
        }
        Assertions.assertThat(car.getDistance()).isEqualTo(0);

        for (int i = 4; i < 10; i++) {
            car.moveOrStop(i);
        }
        Assertions.assertThat(car.getDistance()).isEqualTo(6);
    }
}