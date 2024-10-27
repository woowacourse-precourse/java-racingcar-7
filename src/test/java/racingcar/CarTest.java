package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.models.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @DisplayName("무작위 값이 4 이상이면 자동차가 전진한다.")
    @Test
    void 전진_기능_테스트() {
        Car car = new Car("car");

        car.makeMove(2);
        car.makeMove(4);
        car.makeMove(9);

        assertEquals(2, car.getMoves());
    }
}
