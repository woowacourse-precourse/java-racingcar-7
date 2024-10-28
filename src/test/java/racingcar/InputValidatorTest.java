package racingcar;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validation.InputValidator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputValidatorTest {

    @Test
    void carNameValidate_ShouldThrowException_WhenNameExceedsFiveCharacters() {
        String cars = "ponyCar,choco,Amen";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateCarNames(cars))
                .withMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void carNameValidate_ShouldThrowException_WhenNameIsEmpty() {
        String cars = "pobi,,jun"; // 빈 이름이 포함된 경우
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateCarNames(cars))
                .withMessage("자동차 이름은 빈 문자열일 수 없습니다.");
    }

    @Test
    void carNameValidate_ShouldNotThrowException_WhenNamesAreValid() {
        String cars = "pobi,jun";
        assertDoesNotThrow(() -> InputValidator.validateCarNames(cars));
    }


    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void validateTryNumber_ShouldNotThrowException_WhenValid(String tryNumber) {
        assertDoesNotThrow(() -> InputValidator.validateTryNumber(tryNumber));
    }
}