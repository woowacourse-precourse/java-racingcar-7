package racingcar.support.repeater;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCountException;

@DisplayName("문자열 리피터 테스트")
class StringRepeaterTest {

    @Test
    @DisplayName("문자열을 주어진 횟수만큼 반복한다")
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
