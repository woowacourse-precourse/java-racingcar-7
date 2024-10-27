package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringValidatorTest {

    private final StringValidator stringValidator = new StringValidator();

    @DisplayName("공통 문자열 검증 기능 - null입력 검증")
    @Test
    public void null_입력_검증() {
        String nullString = null;
        assertThatThrownBy(() -> stringValidator.isNull(nullString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null 값이 입력되었습니다.");
    }

    @DisplayName("공통 문자열 검증 기능 - 비어있는 값 입력 검증")
    @Test
    public void 비어있는_값_입력_검증() {
        String blankString = "    ";
        assertThatThrownBy(() -> stringValidator.isBlank(blankString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비어있는 값이 입력되었습니다.");
    }

    @DisplayName("공통 문자열 검증 기능 - 숫자가 아닌 값 입력 검증")
    @Test
    public void 숫자가_아닌_값_입력_검증() {
        String notNumericString = "five";
        assertThatThrownBy(() -> stringValidator.isNotNumeric(notNumericString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 입력되었습니다.");
    }

    @DisplayName("공통 문자열 검증 기능 - int범위를 넘는 값 입력 검증")
    @ParameterizedTest(name = "\"{0}\"이 입력된 경우")
    @ValueSource(strings = {"9999999999999", "-9999999999999"})
    public void int범위를_넘는_값_입력_검증(String outOfIntegerString) {
        assertThatThrownBy(() -> stringValidator.isOutOfIntegerRange(outOfIntegerString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Integer 범위를 벗어난 값이 입력되었습니다.");
    }

    @DisplayName("공통 문자열 검증 기능 - 음수나 0 입력 검증")
    @ParameterizedTest(name = "\"{0}\"이 입력된 경우")
    @ValueSource(strings = {"0", "-1", "-100"})
    public void 음수나_0_입력_검증(String zeroOrMinusString) {
        assertThatThrownBy(() -> stringValidator.isZeroOrMinus(zeroOrMinusString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0보다 작은 값이 입력되었습니다.");
    }
}