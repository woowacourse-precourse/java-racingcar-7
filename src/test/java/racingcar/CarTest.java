package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest{
    @Test
    @DisplayName("자동차 초기화")
    public void init() {
        Car car = new Car("test");
        Assertions.assertEquals("test", car.getName());
        Assertions.assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차 움직이기")
    public void moveForward() {
        Car car = new Car("test");
        car.forward();
        Assertions.assertEquals(1, car.getPosition());
    }
}
