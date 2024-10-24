package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.InputValidator.validateInputCarNameFormat;
import static racingcar.util.InputValidator.validateInputCountFormat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    @DisplayName("입력한 자동차 이름이 빈문자열이므로 예외가 발생한다.")
    void validateInputCarNameFormatTest() throws Exception {
        //given
        final String carName = "";

        //when
        //then
        assertThatThrownBy(() -> validateInputCarNameFormat(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ㄱ", " ", "."})
    @DisplayName("입력한 시도 횟수가 숫자가 아니므로 예외가 발생한다.")
    void validateInputCountFormatTest(final String count) throws Exception {
        //given
        //when
        //then
        assertThatThrownBy(() -> validateInputCountFormat(count)).isInstanceOf(IllegalArgumentException.class);

    }

}