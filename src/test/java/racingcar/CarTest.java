package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Test");
    }

    @Test
    void testCarInitialization() {
        //when
        String name = car.getName();
        String moveHistory = car.getMoveHistory();

        assertNotNull(car, "Car 객체가 생성되지 않았습니다");
        assertEquals("Test", name, "이름이 올바르게 설정되지 않았습니다");
        assertEquals("", moveHistory, "이동 기록이 올바르게 설정되지 않았습니다");
    }

    @RepeatedTest(10)
    void testMove() {
        int initialLength = car.getMoveHistory().length();
        car.move();
        int newLength = car.getMoveHistory().length();

        assertTrue(newLength == initialLength || newLength == initialLength + 1,
                "이동 기록이 올바르게 업데이트되지 않았습니다.");
    }
}