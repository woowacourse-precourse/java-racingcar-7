package racingcar.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameValidationError;

public class CarTest {

    @Test
    @DisplayName("자동차 생성")
    void createCar() {
        // Given
        Car car = new Car("pobi");

        // When
        final String name = car.getName();
        final int position = car.getPosition();

        // Then
        assertEquals("pobi", name);
        assertEquals(0, position);
    }

    @Test
    @DisplayName("자동차 생성 실패 (이름 길이 5 초과)")
    void failWhenNameTooLong() {
        // Given & When & Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new Car("123456"),
                CarNameValidationError.NAME_TOO_LONG.getMessage()
        );
    }

    @Test
    @DisplayName("자동차 생성 실패 (입력이 빈 문자열인 경우)")
    void failWhenNameEmpty() {
        // Given & When & Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new Car(""),
                CarNameValidationError.NAME_EMPTY.getMessage()
        );
    }

    @Test
    @DisplayName("자동차 생성 실패 (공백이 포함된 이름)")
    void failWhenNameHasSpace() {
        // Given & When & Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new Car("pobi "),
                CarNameValidationError.NAME_CONTAINS_SPACE.getMessage()
        );
    }

    @Test
    @DisplayName("자동차 생성 실패 (입력이 null인 경우)")
    void failWhenNameNull() {
        // Given & When & Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new Car(null),
                CarNameValidationError.NAME_NULL.getMessage()
        );
    }

    @Test
    @DisplayName("자동차 이동")
    void moveCar() {
        // Given
        Car car = new Car("pobi");

        // When
        car.move(4);

        // Then
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("자동차 정지")
    void stopCar() {
        // Given
        Car car = new Car("pobi");

        // When
        car.move(3);

        // Then
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차 2번 이동")
    void moveCarTwice() {
        // Given
        Car car = new Car("pobi");

        // When
        car.move(4);
        car.move(4);

        // Then
        assertEquals(2, car.getPosition());
    }

    @Test
    @DisplayName("자동차 1번 이동 1번 정지")
    void moveCarOnceStopOnce() {
        // Given
        Car car = new Car("pobi");

        // When
        car.move(4);
        car.move(3);

        // Then
        assertEquals(1, car.getPosition());
    }
}
