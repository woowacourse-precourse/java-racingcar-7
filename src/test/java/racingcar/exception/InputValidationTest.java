package racingcar.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {

    @DisplayName("문자열이 null 또는 빈문자열 이라면 true를 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void inputNullOrEmpty(String input) {
        //given //when
        boolean result = InputValidation.validateNullOrEmpty(input);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("문자열에 공백이 있다면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "pobi ", "pobi,woni, jun"})
    void inputBlank(String input) {
        //given //when
        boolean result = InputValidation.validateBlank(input);

        //then
        assertThat(result).isTrue();
    }
}