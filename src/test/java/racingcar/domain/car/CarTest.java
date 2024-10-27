package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final CarName DUMMY_NAME = CarName.of("dummy");

    @Test
    @DisplayName("CarName을 통해 생성시 0의 값의 Position을 갖는 Car를 생성하는지 확인")
    void testDefaultPosition() {
        int defaultPositionValue = 0;
        Car car = new Car(DUMMY_NAME);
        CarPosition expected = CarPosition.of(defaultPositionValue);

        CarPosition actual = car.getCarPosition();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("moveForward 호출 시 position값이 1커진 Car를 반환하는지 확인")
    void testMoveForward() {
        int startPositionValue = 1;
        Car car = new Car(DUMMY_NAME, CarPosition.of(startPositionValue));
        Car after = car.moveForward();
        CarPosition expected = CarPosition.of(startPositionValue + 1);

        CarPosition actual = after.getCarPosition();

        assertThat(actual).isEqualTo(expected);
    }
}