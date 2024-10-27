package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

public class CarTest {
    @DisplayName("4 이상의 값이 들어온 경우 - 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void testMoveFoward(int input) {
        Car car = new Car("test");
        car.move(input);
        assertEquals(1, car.getMoveCount());
    }

    @DisplayName("4 미만의 값이 들어온 경우 - 멈춤")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void testNotMove(int input) {
        Car car = new Car("test");
        car.move(input);
        assertEquals(0, car.getMoveCount());
    }


}
