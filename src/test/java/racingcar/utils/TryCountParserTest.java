package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountParserTest {
    @Nested
    @DisplayName("파싱 기능 테스트")
    class ParserTest {
        @Test
        void String_타입을_int_타입으로_반환() {
            // given
            String input = "3";

            // when
            int actual = TryCountParser.parse(input);
            int expected = 3;

            // then
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("예외처리 테스트")
    class TryCountExceptionTest {
        @Test
        void 시도횟수가_숫자가_아닐_때_예외처리() {
            // given
            String input = "abc123";

            // when, then
            assertThatThrownBy(() -> TryCountParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 시도횟수는 숫자로만 입력되어야 합니다.");
        }

        @Test
        void 시도횟수가_1회_미만일_때_예외처리() {
            // given
            String input = "0";

            // when. then
            assertThatThrownBy(() -> TryCountParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 1이상의 숫자만 입력 가능합니다.");
        }

        @Test
        void 시도횟수가_int_범위를_넘어갔을_때_예외처리() {
            // given
            String input = "2147483649";

            // when. then
            assertThatThrownBy(() -> TryCountParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] int 범위의 숫자로만 입력되어야 합니다.");
        }
    }
}
