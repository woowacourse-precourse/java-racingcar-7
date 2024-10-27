package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.INVALID_COUNT_RANGE;
import static racingcar.exception.ErrorMessage.NOT_INTEGER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-123"})
    @DisplayName("레이싱 횟수는 1 이상이여한다. 1 미만인 경우 예외가 발생한다.")
    void countRangeValidate(String count) {
        assertThatThrownBy(() -> CountValidator.countValidate(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_COUNT_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "1,2", "as2"})
    @DisplayName("횟수 입력은 숫자만 가능하다. 숫자가 아닌 입력이 오면 예외가 발생한다.")
    void numberFormatValidate(String count) {
        assertThatThrownBy(() -> CountValidator.countValidate(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_INTEGER.getMessage());
    }

    @Test
    @DisplayName("정상 횟수 입력 값에 대해서는 int 형이 정확히 나와야한다.")
    void successCountValidate() {
        // given
        String input = "1";
        // when & then
        assertThatNoException().isThrownBy(() -> CountValidator.countValidate(input));
    }

}