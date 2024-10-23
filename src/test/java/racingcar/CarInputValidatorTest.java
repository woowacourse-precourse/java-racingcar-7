package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validators.CarInputValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarInputValidatorTest {
    private final CarInputValidator validator = new CarInputValidator();

    @DisplayName("자동차 이름으로 입력한 값이 유효하지 않으면 예외를 발생시킨다.")
    @Test
    void 자동차_입력값_검증_테스트() {
        assertThrows(RuntimeException.class, () -> validator.validate("car1"));
        assertThrows(RuntimeException.class, () -> validator.validate("car111,car2"));
        assertThrows(RuntimeException.class, () -> validator.validate("car,car"));
    }
}
