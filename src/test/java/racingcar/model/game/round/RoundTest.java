package racingcar.model.game.round;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidRoundException;

@DisplayName("시도 횟수 테스트")
class RoundTest {

    @Nested
    @DisplayName("생성 테스트")
    class createTest {

        @Test
        @DisplayName("0 이상의 수이면 성공적으로 생성한다")
        void 성공_생성_유효한파라미터() {
            // Given

            // When & Then
            assertThatCode(() -> {
                new Round("0");
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("음수이면 예외를 발생한다")
        void 실패_생성_음수() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new Round("-1"))
                    .isExactlyInstanceOf(InvalidRoundException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도할 횟수는 0 또는 양수여야 합니다.");
        }

        @Test
        @DisplayName("숫자가 아닌 문자이면 예외를 발생한다")
        void 실패_생성_숫자가아닌문자() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new Round("a"))
                    .isExactlyInstanceOf(InvalidRoundException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도할 횟수는 숫자여야 합니다.");
        }

        @Test
        @DisplayName("null이면 예외를 발생한다")
        void 실패_생성_null() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new Round(null))
                    .isExactlyInstanceOf(InvalidRoundException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("라운드 횟수는 null이거나 공백일 수 없습니다.");
        }

        @Test
        @DisplayName("비어있으면 예외를 발생한다")
        void 실패_생성_empty() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new Round(null))
                    .isExactlyInstanceOf(InvalidRoundException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("라운드 횟수는 null이거나 공백일 수 없습니다.");
        }

        @Test
        @DisplayName("공백이면 예외를 발생한다")
        void 실패_생성_공백() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new Round(" "))
                    .isExactlyInstanceOf(InvalidRoundException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("라운드 횟수는 null이거나 공백일 수 없습니다.");
        }
    }
}
