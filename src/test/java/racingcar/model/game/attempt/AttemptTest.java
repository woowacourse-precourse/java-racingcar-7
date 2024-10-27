package racingcar.model.game.attempt;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidAttemptException;
import racingcar.model.game.attempt.Attempt;

@DisplayName("시도 횟수 테스트")
class AttemptTest {

    @Nested
    @DisplayName("생성 테스트")
    class createTest {

        @Test
        @DisplayName("0 이상의 수이면 성공적으로 생성한다")
        void 성공_생성_유효한파라미터() {
            // Given

            // When & Then
            assertThatCode(() -> {
                new Attempt(0);
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("음수이면 예외를 발생한다")
        void 실패_생성_음수() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new Attempt(-1))
                    .isExactlyInstanceOf(InvalidAttemptException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도 횟수는 0 또는 양수여야 합니다.");
        }
    }
}
