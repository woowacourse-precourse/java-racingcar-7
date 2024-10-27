package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("랜덤 숫자가 4 이상일 때 자동차가 이동하는지 테스트")
    void moveCarWhenRandomIsGreaterOrEqualToFour() {
        Car car = new Car("obi");
        int initialPosition = car.getPosition();

        for (int i = 0; i < 100; i++) {
            car.move();
        }

        assertThat(car.getPosition()).isGreaterThanOrEqualTo(initialPosition);
    }
}
