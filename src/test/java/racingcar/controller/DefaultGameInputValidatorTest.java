package racingcar.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
                .hasMessage("자동차의 이름은 빈 문자열이어서는 안됩니다.");
    }

    @ParameterizedTest
    @DisplayName("사용자가 입력한 자동차의 이름이 구분자로만 이루어져 있으면 예외를 던진다.")
    @ValueSource(strings = {",", ",,,,", ",,,,,,,,,,,,,,"})
    void throwExceptionWhenNameContainsOnlyDelimiter(String inputValue) {
        // when & then
        assertThatThrownBy(() -> gameInputValidator.validateNameOfCars(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 구분자인 쉼표(,)로만 이루어질 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("사용자가 입력한 자동차의 이름이 구분자로 끝나면 예외를 던진다.")
    @ValueSource(strings = {"pobi,", "jun,woni,"})
    void throwExceptionWhenNameEndsWithDelimiter(String inputValue) {
        // when & then
        assertThatThrownBy(() -> gameInputValidator.validateNameOfCars(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 구분자인 쉼표(,)로 끝나서는 안됩니다.");
    }

    @ParameterizedTest
    @DisplayName("사용자가 입력한 자동차의 이름이 숫자, 알파벳, 한글에 포함되지 않는 경우 예외를 던진다.")
    @ValueSource(strings = {"pobi**", "jun,w*oni", "中,22"})
    void throwExceptionWhenNameContainsInvalidCharactersForNameOfCars(String inputValue) {
        // when & then
        assertThatThrownBy(() -> gameInputValidator.validateNameOfCars(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 숫자, 알파벳, 한글만 가능합니다.");
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
                .hasMessage("총 라운드는 정수 형태로 입력하셔야 합니다.");
    }


    @ParameterizedTest
    @DisplayName("사용자가 입력한 총 라운드가 빈 값이면 예외를 던진다.")
    @ValueSource(strings = {"", " ", "       "})
    void throwExceptionWhenTotalRoundsIsBlank(String inputValue) {
        // when & then
        assertThatThrownBy(() -> gameInputValidator.validateTotalRounds(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("총 라운드는 빈 값을 입력하실 수 없습니다.");
    }

}
