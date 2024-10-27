package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("차의 이름이 5보다 클 때, 예외 발생")
    void testCarNameTooLong() {
        // Given
        String longName = "pobi Maguire";

        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Car(longName));
        assertEquals("Car name has to be 5 or under 5.", exception.getMessage());
    }

    @Test
    @DisplayName("차 이름이 올바를 때, 차 이름 가져오기")
    void testCarNameValid() {
        // Given
        String validName = "pobi";

        // When
        Car car = new Car(validName);

        // Then
        assertEquals(validName, car.getName());
    }

    @Test
    @DisplayName("차가 움직일 조건일 때, 앞으로 가는지 확인")
    void testMoveIfPossibleMovesCar() {
        // Given
        Car car = new Car("pobi", () -> MOVING_FORWARD);

        // When
        car.moveIfPossible();
        car.moveIfPossible();

        // Then
        assertEquals("pobi : --", car.toString());
    }

    @Test
    @DisplayName("차가 움직이지 않는 조건일 때, 움직이지 않는지 확인")
    void testMoveIfPossibleDoesNotMoveCar() {
        // Given
        Car car = new Car("pobi", () -> STOP);

        // When
        car.moveIfPossible();
        car.moveIfPossible();

        // Then
        assertEquals("pobi : ", car.toString());
    }

    @Test
    @DisplayName("toString() 함수가 제대로 동작하는지 확인")
    void testToString() {
        // Given
        Car car = new Car("pobi", () -> MOVING_FORWARD);

        // When
        car.moveIfPossible();
        car.moveIfPossible();
        car.moveIfPossible();

        // Then
        assertEquals("pobi : ---", car.toString());
    }

    @Test
    @DisplayName("아무 움직임이 없을 때, 제대로 출력하는지 확인")
    void testToStringWithZeroPosition() {
        // Given
        Car car = new Car("pobi", () -> STOP);

        // When
        // 아무 움직임이 없을 때

        // Then
        assertEquals("pobi : ", car.toString());
    }
}
