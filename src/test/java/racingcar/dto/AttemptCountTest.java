package racingcar.dto;

import static org.assertj.core.api.Assertions.*;
import static racingcar.common.exception.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.exception.RacingCarException;


class AttemptCountTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @ParameterizedTest
        @ValueSource(strings = {"1", "5", "10", "20"})
        @DisplayName("1에서 20 사이의 값이 정상적으로 AttemptCount에 저장된다")
        void 정상적인_값이_AttemptCount에_저장된다(String validAttemptCount) {
            AttemptCount attemptCount = AttemptCount.from(validAttemptCount);

            assertThat(attemptCount.value())
                    .isEqualTo(Integer.parseInt(validAttemptCount));
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @ParameterizedTest
        @ValueSource(strings = {"0", "21", "100"})
        @DisplayName("시도 횟수가 1에서 20 사이가 아닐 경우 예외가 발생한다")
        void 시도_횟수가_범위를_벗어나면_예외가_발생한다(String invalidAttemptCount) {
            assertThatThrownBy(() -> AttemptCount.from(invalidAttemptCount))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessage(ATTEMPT_COUNT_OUT_OF_RANGE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "abc", "3.5", "!"})
        @DisplayName("입력 값이 숫자가 아닌 경우 예외가 발생한다")
        void 입력_값이_숫자가_아니면_예외가_발생한다(String invalidAttemptCount) {
            assertThatThrownBy(() -> AttemptCount.from(invalidAttemptCount))
                    .isInstanceOf(RacingCarException.class)
                    .hasMessage(ATTEMPT_COUNT_MUST_BE_NUMERIC.getMessage());
        }
    }
}