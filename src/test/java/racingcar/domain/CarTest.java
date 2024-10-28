package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름과_초기_위치_확인() {
        Car car = new Car("pobi");
        assertEquals("pobi", car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    void 자동차_이동_확인() {
        Car car = new Car("pobi");
        car.move();
        assertEquals(1, car.getPosition());
    }
}
