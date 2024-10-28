package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ForwardTest {
    @DisplayName("움직이지 않았을 떄 position 의 값은 0")
    @Test
    void notMoveTest() {
        Car car = new Car("car"); // Corrected the instantiation of the Car object

        assertThat(car.getPosition()).isEqualTo(0); // Verify that the initial position is 0
    }


    @DisplayName("1번 전진했을 떄 position 의 값은 1")
    @Test
    void moveOneTest() {
        Car car = new Car("car");

        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("2번 전진했을 떄 position 값은 1이 아님.")
    @Test
    void differentPositionTest() {
        Car car = new Car("car");

        car.moveForward();
        car.moveForward();

        assertThat(car.getPosition()).isNotEqualTo(1);
    }

}
