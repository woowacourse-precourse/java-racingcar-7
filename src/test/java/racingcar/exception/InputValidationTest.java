package racingcar.exception;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {

    @DisplayName("자동차의 이름이 null이거나 빈 문자열이면 예외를 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void carNamesNullOrEmpty(String input) {
        //given //when //then
        assertThatThrownBy(() -> InputValidation.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름에 공백이 있다면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "pobi ", "po bi,wo ni", "pobi,woni, jun",})
    void carNameContainsBlank(String input) {
        //given //when //then
        assertThatThrownBy(() -> InputValidation.validateRacingCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도횟수가 null이거나 빈 문자열이면 예외를 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void tryCountNullOrEmpty(String input) {
        //given //when //then
        assertThatThrownBy(() -> InputValidation.validateRacingCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수에 공백이 있다면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "1 ", "1 2"})
    void tryCountContainsBlank(String input) {
        //given //when //then
        assertThatThrownBy(() -> InputValidation.validateRacingCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("연속된 구분자를 입력한 경우 예외를 발생한다.")
    @Test
    void sequenceDelimiter() {
        //given
        String carNames = "pobi,woni,,jun";
        String[] splitCarNames = carNames.split(",");

        // when //then
        assertThatThrownBy(() -> InputValidation.validateDelimiter(splitCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름에 공백이 있지 않다면 예외를 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,woni", "pobi,woni,jun"})
    void nonCarNameContainsBlank(String input) {
        //given //when //then
        assertThatCode(() -> InputValidation.validateCarNames(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("시도 횟수에 공백이 없다면 예외를 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "12"})
    void nonTryCountContainsBlank(String input) {
        //given //when //then
        assertThatCode(() -> InputValidation.validateRacingCount(input))
                .doesNotThrowAnyException();
    }
}