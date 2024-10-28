package racingcar.support.repeater;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCountException;
import racingcar.exception.InvalidValueException;

@DisplayName("문자열 리피터 테스트")
class StringRepeaterTest {
    @Nested
    @DisplayName("리피터 생성 테스트")
    class 리피터_생성 {
        @Test
        @DisplayName("유효한 문자열이면 성공적으로 생성한다")
        void 성공_리피터생성_유효한문자열() {
            // Given

            // When & Then
            assertThatCode(() -> {
                new StringRepeater("-");
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("문자열이 null이면 예외가 발생한다")
        void 실패_리피터생성_null() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new StringRepeater(null))
                    .isExactlyInstanceOf(InvalidValueException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("반복할 문자열은 null이거나 빈 값일 수 없습니다.");
        }

        @Test
        @DisplayName("문자열이 비어있으면 예외가 발생한다")
        void 실패_리피터생성_empty() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new StringRepeater(""))
                    .isExactlyInstanceOf(InvalidValueException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("반복할 문자열은 null이거나 빈 값일 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("구분자 반복 테스트")
    class 구분자_반복{
        @Test
        @DisplayName("주어진 횟수만큼 반복한다")
        void 성공_문자열반복() {
            // Given
            StringRepeater stringRepeater = new StringRepeater("-");

            // When
            String repeat = stringRepeater.repeat(5);

            // Then
            assertThat(repeat).isEqualTo("-----");
        }

        @Test
        @DisplayName("주어진 횟수가 음수이면 예외가 발생한다")
        void 실패_문자열반복_음수() {
            // Given
            StringRepeater stringRepeater = new StringRepeater("-");

            // When & Then
            assertThatThrownBy(() -> stringRepeater.repeat(-1))
                    .isExactlyInstanceOf(InvalidCountException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("count는 음수일 수 없습니다.");
        }
    }
}
