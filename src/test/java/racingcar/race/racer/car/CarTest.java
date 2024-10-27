package racingcar.race.racer.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    CarUtils carUtils = CarUtils.getInstance();

    @DisplayName("숫자가 4 ~ 9 사이일 경우 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_전진(int number) {
        Car car = new Car("pobi");
        boolean movable = carUtils.isMovable(number);
        car.tryMove(movable);
        String expected = "-";

        assertEquals(expected, car.getDistance());
    }

    @DisplayName("숫자가 0 ~ 3 사이일 경우 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_스탑(int number) {
        Car car = new Car("pobi");
        boolean movable = carUtils.isMovable(number);
        car.tryMove(movable);
        String expected = "";

        assertEquals(expected, car.getDistance());
    }
}