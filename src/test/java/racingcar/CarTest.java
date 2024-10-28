package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_객체_생성_및_초기_위치_확인() {
        Car car = new Car("pobi");

        assertEquals("pobi", car.getName());
        assertEquals(0, car.getPosition());
    }
}
