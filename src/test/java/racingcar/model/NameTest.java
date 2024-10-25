package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NameTest {

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("이름이 null이면 IllegalArgumentException을 발생시킨다")
        void testNameIsNull() {
            // when & then
            assertThatThrownBy(() -> new Name(null))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("이름이 빈 문자열이면 IllegalArgumentException을 발생시킨다")
        void testNameIsBlank() {
            // when & then
            assertThatThrownBy(() -> new Name(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("이름이 공백 문자만 포함되어 있을 경우 IllegalArgumentException을 발생시킨다")
        void testNameIsOnlySpaces() {
            // when & then
            assertThatThrownBy(() -> new Name("   "))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("이름이 5자를 초과하면 IllegalArgumentException을 발생시킨다")
        void testNameExceedsMaxLength() {
            // given
            String name = "songjeyong";

            // when & then
            assertThatThrownBy(() -> new Name(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
