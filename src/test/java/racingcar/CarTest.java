package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.vaildation.Vaild;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 5자를 초과할 때 예외를 발생시킨다")
    void carNameLengthExceedsLimit() {
        String invalidName = "excessive";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Car(invalidName));
        assertEquals("자동차 이름은 5자 이하여야 합니다.", thrown.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 비어 있을 때 예외를 발생시킨다")
    void carNameIsEmpty() {
        String emptyName = "";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Car(emptyName));
        assertEquals("자동차 이름을 입력해야 합니다.", thrown.getMessage());
    }

    @Test
    @DisplayName("자동차가 이동 조건을 만족할 때 이동한다")
    void carMovesWhenConditionIsMet() {
        Car car = new Car("test");
        int initialPosition = car.getPosition();

        car.moveTry(5);
        assertEquals(initialPosition + 1, car.getPosition());
    }

    @Test
    @DisplayName("자동차가 이동 조건을 만족하지 않을 때 위치가 그대로이다")
    void carDoesNotMoveWhenConditionIsNotMet() {
        Car car = new Car("test");
        int initialPosition = car.getPosition();

        car.moveTry(3);
        assertEquals(initialPosition, car.getPosition());
    }

    @Test
    @DisplayName("자동차 이름에 대한 유효성 검사 테스트")
    void validateCarNameTest() {
        assertThrows(IllegalArgumentException.class, () -> Vaild.validateCarName(null));
        assertThrows(IllegalArgumentException.class, () -> Vaild.validateCarName(""));
        assertThrows(IllegalArgumentException.class, () -> Vaild.validateCarName("longname"));
    }
}
