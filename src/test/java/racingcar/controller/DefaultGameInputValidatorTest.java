package racingcar.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.controller.ExceptionMessages.Default.CAR_NAME_ENDS_WITH_DELIMITER;
import static racingcar.controller.ExceptionMessages.Default.CAR_NAME_ONLY_DELIMITER;
import static racingcar.controller.ExceptionMessages.Default.EMPTY_CAR_NAME;
import static racingcar.controller.ExceptionMessages.Default.EMPTY_TOTAL_ROUNDS;
import static racingcar.controller.ExceptionMessages.Default.INVALID_CAR_NAME_CHARACTERS;
import static racingcar.controller.ExceptionMessages.Default.TOTAL_ROUNDS_NOT_INTEGER;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DefaultGameInputValidatorTest {

    private DefaultGameInputValidator gameInputValidator;

    @BeforeEach
    void setUp() {
        this.gameInputValidator = DefaultGameInputValidator.getInstance();
    }

    @ParameterizedTest
    @DisplayName("사용자가 입력한 자동차의 이름이 빈 값이면 예외를 던진다.")
    @ValueSource(strings = {"", " ", "        "})
    void throwExceptionWhenNameOfCarsIsBlank(String inputValue) {
        // when & then
        assertThatThrownBy(() -> gameInputValidator.validateNameOfCars(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_CAR_NAME);
    }

    @ParameterizedTest
    @DisplayName("사용자가 입력한 자동차의 이름이 구분자로만 이루어져 있으면 예외를 던진다.")
    @ValueSource(strings = {",", ",,,,", ",,,,,,,,,,,,,,"})
    void throwExceptionWhenNameContainsOnlyDelimiter(String inputValue) {
        // when & then
        assertThatThrownBy(() -> gameInputValidator.validateNameOfCars(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_ONLY_DELIMITER);
    }

    @ParameterizedTest
    @DisplayName("사용자가 입력한 자동차의 이름이 구분자로 끝나면 예외를 던진다.")
    @ValueSource(strings = {"pobi,", "jun,woni,"})
    void throwExceptionWhenNameEndsWithDelimiter(String inputValue) {
        // when & then
        assertThatThrownBy(() -> gameInputValidator.validateNameOfCars(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_ENDS_WITH_DELIMITER);
    }

    @ParameterizedTest
    @DisplayName("사용자가 입력한 자동차의 이름이 숫자, 알파벳, 한글에 포함되지 않는 경우 예외를 던진다.")
    @ValueSource(strings = {"pobi**", "jun,w*oni", "中,22"})
    void throwExceptionWhenNameContainsInvalidCharactersForNameOfCars(String inputValue) {
        // when & then
        assertThatThrownBy(() -> gameInputValidator.validateNameOfCars(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME_CHARACTERS);
    }

    @ParameterizedTest
    @DisplayName("사용자가 입력한 자동차의 이름이 숫자, 알파벳, 한글에 포함된 경우 예외를 던지지 않는다.")
    @ValueSource(strings = {"r12n", "한글eng"})
    void doesNotThrowExceptionWhenNameContainsOnlyValidCharactersForNameOfCars(String inputValue) {
        // when & then
        assertDoesNotThrow(() -> gameInputValidator.validateNameOfCars(inputValue));
    }

    @ParameterizedTest
    @DisplayName("사용자가 입력한 총 라운드가 정수가 아니라면 예외를 던진다.")
    @ValueSource(strings = {"abc", "123abc", "42.5"})
    void throwExceptionWhenTotalRoundsIsNotPositiveInteger(String inputValue) {
        // when & then
        assertThatThrownBy(() -> gameInputValidator.validateTotalRounds(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOTAL_ROUNDS_NOT_INTEGER);
    }


    @ParameterizedTest
    @DisplayName("사용자가 입력한 총 라운드가 빈 값이면 예외를 던진다.")
    @ValueSource(strings = {"", " ", "       "})
    void throwExceptionWhenTotalRoundsIsBlank(String inputValue) {
        // when & then
        assertThatThrownBy(() -> gameInputValidator.validateTotalRounds(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_TOTAL_ROUNDS);
    }

}
