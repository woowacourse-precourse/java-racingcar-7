package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RangeValidatorTest {

    private static final String ERROR_MESSAGE_FORMAT = "%d 이상의 숫자만 가능합니다.";
    private static final int MIN_ATTEMPTS_COUNT = 0;

    RangeValidator validator = new RangeValidator();

    @Test
    @DisplayName("0 미만 입력이 들어오면 에러 발생")
    void check_0_미만_입력_에러발생() {
        // given
        int input = -1;

        // when & then
        assertThatThrownBy(() -> validator.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ERROR_MESSAGE_FORMAT, MIN_ATTEMPTS_COUNT));
    }

    @Test
    @DisplayName("정상 입력이 들어오면 성공")
    void check_정상입력_성공() {
        // given
        int input = 1;

        // when & then
        assertThatCode(() -> validator.check(input))
                .doesNotThrowAnyException();
    }


}