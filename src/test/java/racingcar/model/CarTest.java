package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.randomnumbergenerator.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("무작위 숫자가 4 이상일 때 자동차가 이동한다")
    void move_forward() {
        // Given
        RandomNumberGenerator fixedNumberGenerator = () -> 4;
        Car car = new Car("pobi");

        // When
        car.move(fixedNumberGenerator);

        // Then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("무작위 숫자가 4 미만일 때 자동차가 이동하지 않는다")
    void move_stop() {
        // Given
        RandomNumberGenerator fixedNumberGenerator = () -> 3;
        Car car = new Car("woni");

        // When
        car.move(fixedNumberGenerator);

        // Then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
