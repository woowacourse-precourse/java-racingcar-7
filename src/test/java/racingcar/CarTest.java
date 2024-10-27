package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_전진_성공_4이상(int randomNum) {
        // given
        Car car = new Car("car1");
        int position = car.getPosition();

        // when
        car.move(randomNum);

        // then
        assertEquals(position + 1, car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_정지_성공_4미만(int randomNum) {
        // given
        Car car = new Car("car1");
        int position = car.getPosition();

        // when
        car.move(randomNum);

        // then
        assertEquals(position, car.getPosition());
    }
}
