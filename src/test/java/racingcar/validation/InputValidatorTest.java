package racingcar.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @DisplayName("이름을 아무것도 입력하지 않았을 경우 예외가 발생한다.")
    @NullAndEmptySource
    void emptyInputNameException(String name) {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateCarName(name));
    }

    @ParameterizedTest
    @DisplayName("이름이 5자를 초과할 경우 예외가 발생한다.")
    @ValueSource(strings = "pobibi")
    void inputCarNameOverLengthException(String name) {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateCarName(name));
    }

    @ParameterizedTest
    @DisplayName("이름이 영어로 이루어져 있지 않을 경우 예외가 발생한다.")
    @ValueSource(strings = "우테코")
    void inputCarNameNotEnglishException(String name) {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateCarName(name));
    }

    @ParameterizedTest
    @DisplayName("시도 횟수를 아무것도 입력하지 않았을 경우 예외가 발생한다.")
    @NullAndEmptySource
    void emptyInputTryCountException(String count) {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateTryCount(count));
    }

    @ParameterizedTest
    @DisplayName("시도 횟수를 숫자가 아닌 값으로 입력했을 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "10a"})
    void inputTryCountNotNumberException(String count) {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateTryCount(count));
    }

    @ParameterizedTest
    @DisplayName("시도 횟수가 범위를 벗어났을 경우 예외가 발생한다.")
    @ValueSource(strings = {"11", "-1", "0"})
    void inputTryCountOutOfRangeException(String count) {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateTryCount(count));
    }

}
