package racingcar.model;

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
    void 자동차_초기_위치_테스트() {
        // given
        String expectedName = "pobi";
        int expectedPosition = 0;

        // when & then
        assertEquals(expectedName, car.getName());  // 이름이 올바르게 설정되었는지 확인
        assertEquals(expectedPosition, car.getPosition());  // 초기 위치가 0인지 확인
    }

    @Test
    void 위치_전진_테스트() {
        // given
        int initialPosition = car.getPosition();

        // when
        car.moveForward();

        // then
        assertEquals(initialPosition + 1, car.getPosition()); // 위치가 1 증가했는지 확인
    }
}