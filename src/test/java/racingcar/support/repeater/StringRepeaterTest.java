package racingcar.support.repeater;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
