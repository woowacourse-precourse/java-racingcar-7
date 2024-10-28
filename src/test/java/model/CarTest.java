package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.MoveStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    @DisplayName("Car의 초기 위치가 잘 설정되는지 확인")
    void getPosition() {
        assertEquals(0, car.getPosition(), "초기 위치는 0이어야 합니다.");
    }

    @Test
    @DisplayName("Car의 초기 이름이 잘 설정되는지 확인")
    void getName() {
        assertEquals("test", car.getName(), "초기 이름은 'test'이어야 합니다.");
    }

    @Test
    @DisplayName("Car의 move가 이동 가능한 경우에 위치가 증가하는지 확인")
    void testCarMove() {
        MoveStrategy moveStrategy = () -> true; // 이동 가능하도록 설정
        car.move(moveStrategy);
        assertEquals(1, car.getPosition(), "이동 가능한 경우 위치가 증가해야 합니다.");
    }

    @Test
    @DisplayName("Car의 move가 이동 불가능한 경우에 위치가 유지되는지 확인")
    void testCarNoMove() {
        MoveStrategy moveStrategy = () -> false; // 이동 불가능하도록 설정
        car.move(moveStrategy);
        assertEquals(0, car.getPosition(), "이동 불가능한 경우 위치가 유지되어야 합니다.");
    }

    @Test
    @DisplayName("toString 메서드가 올바르게 동작하는지 확인")
    void testToString() {
        // 초기 위치일 때
        String initialString = car.toString();
        assertTrue(initialString.contains("test : "), "초기 상태의 toString이 예상과 일치해야 합니다.");

        // 이동 후 상태 확인
        MoveStrategy moveStrategy = () -> true;
        car.move(moveStrategy);
        String afterMoveString = car.toString();
        assertTrue(afterMoveString.contains("test : -"), "이동 후 상태의 toString이 예상과 일치해야 합니다.");
    }
}
