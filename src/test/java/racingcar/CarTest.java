package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("차량 전진 확인")
    void test1() {
        CarStatus statingStatus = CarStatus.initStartingStatus();
        Car car = new Car(statingStatus);

        car.move();

        Assertions.assertTrue(car.getStatus().isAhead(statingStatus));
    }
}
