package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessages.TRY_COUNT_NOT_VALID_NUMBER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidInputException;

class TryCountTest {

    private static final int MAX_TRY_COUNT = 1000;

    @Test
    @DisplayName("유효한 시도 횟수가 정상적으로 생성되는지 테스트")
    void createValidTryCount() {
        // given
        String validCount = "5";

        // when
        TryCount tryCount = new TryCount(validCount);

        // then
        assertThat(tryCount.isNotSame(6)).isTrue();
        assertThat(tryCount.isNotSame(5)).isFalse();
    }

    @Test
    @DisplayName("시도 횟수가 최대값일 때 정상적으로 생성되는지 테스트")
    void createTryCountWhenMaxValue() {
        // given
        String maxCount = String.valueOf(MAX_TRY_COUNT);

        // when
        TryCount tryCount = new TryCount(maxCount);

        // then
        assertThat(tryCount.isNotSame(MAX_TRY_COUNT)).isFalse();
    }

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 값이 들어갔을 때 예외 발생 테스트")
    void throwExceptionWhenTryCountIsNotNumeric() {
        // given
        String invalidCount = "abc";

        // when & then
        assertThatThrownBy(() -> new TryCount(invalidCount))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(TRY_COUNT_NOT_VALID_NUMBER);
    }

    @Test
    @DisplayName("시도 횟수가 음수일 때 예외 발생 테스트")
    void throwExceptionWhenTryCountIsNegative() {
        // given
        String negativeCount = "-1";

        // when & then
        assertThatThrownBy(() -> new TryCount(negativeCount))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(TRY_COUNT_NOT_VALID_NUMBER);
    }

    @Test
    @DisplayName("시도 횟수가 최대값을 초과할 때 예외 발생 테스트")
    void throwExceptionWhenTryCountExceedsMaxValue() {
        // given
        String tooLargeCount = String.valueOf(MAX_TRY_COUNT + 1);

        // when & then
        assertThatThrownBy(() -> new TryCount(tooLargeCount))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(TRY_COUNT_NOT_VALID_NUMBER);
    }
}
