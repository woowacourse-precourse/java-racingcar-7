package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validators.CarInputValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarInputValidatorTest {
    private final CarInputValidator validator = new CarInputValidator();

    @DisplayName("자동차 이름으로 입력한 값이 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"car1", "car111,car2", "car,car", "1,2,3,4,5,6,7,8,9,10,11"})
    void 자동차_입력값_검증_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
    }
}
