package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 자동차_이름_반환_테스트() {
        assertEquals("pobi", car.carName());
    }

    @Test
    void 자동차_최근_위치_테스트() {
        assertEquals(0, car.currentPosition());
    }

    @Test
    void 자동차_전진_후_위치_테스트() {
        car.advance();
        car.advance();
        assertEquals(2, car.currentPosition());
    }

}