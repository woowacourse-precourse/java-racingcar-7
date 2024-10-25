package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void carTest() {
        // Given: 자동차 객체 생성
        Car car = new Car("Smith");
        // When: 2회 전진
        car.moveForward();
        car.moveForward();
        // Then: 자동차 이름 일치, 거리는 2
        assertEquals("Smith", car.getName());
        assertEquals(2, car.getDistance());
    }
}