package racingcar.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Racing;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RacingTest {
    Racing racing;
    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @Test
    @DisplayName("전진 횟수 최대값 검증 테스트")
    void validateMax() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("짱구");
        Car car2 = new Car("포비");
        Car car3 = new Car("준");
        car1.move();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        assertEquals(1, racing.compareMoveCount(cars));
    }

}
