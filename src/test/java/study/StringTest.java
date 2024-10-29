package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void 쉼표로_문자열을_분리하면_두_숫자로_분리된다() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).contains("1", "2"); // "1"과 "2"가 결과 배열에 포함되는지 검증
    }

    @Test
    void 쉼표로_단일값을_분리하면_단일값만_포함하는_배열이_반환된다() {
        // given
        String input = "1";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).containsExactly("1"); // "1"과 "2"가 결과 배열에 포함되는지 검증
    }

    @Test
    void 괄호를_제거하고_값을_반환한다() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, input.length() - 1); // 첫 번째와 마지막 문자 제거

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 인덱스를 벗어난 위치에 접근할 때 예외가 발생한다")
    void 인덱스_범위를_벗어나는_경우_예외가_발생한다() {
        // given
        String input = "abc";

        // then
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 3 out of bounds for length 3");
    }
}
