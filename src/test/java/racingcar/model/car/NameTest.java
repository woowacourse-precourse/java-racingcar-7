package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidNameException;

@DisplayName("이름 테스트")
class NameTest {

    @Nested
    @DisplayName("이름 생성 시")
    class createTest {
        @Test
        @DisplayName("5글자 이하이면 성공한다")
        void 성공_이름생성_5글자이하() {
            // Given
            String name = "mint";

            // When & Then
            assertThatCode(() -> {
                new Name(name);
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("5글자를 초과하면 예외를 발생한다")
        void 실패_이름생성_5글자초과() {
            // Given
            String name = "mintyy";

            // When & Then
            assertThatThrownBy(() -> new Name(name))
                    .isExactlyInstanceOf(InvalidNameException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 5글자 이하여야 합니다.");
        }

        @Test
        @DisplayName("빈 문자열이면 예외를 발생한다")
        void 실패_이름생성_빈문자열() {
            // Given
            String name = "";

            // When & Then
            assertThatThrownBy(() -> new Name(name))
                    .isExactlyInstanceOf(InvalidNameException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 null이거나 공백일 수 없습니다.");
        }

        @Test
        @DisplayName("공백이면 예외를 발생한다")
        void 실패_이름생성_공백() {
            // Given
            String name = " ";

            // When & Then
            assertThatThrownBy(() -> new Name(name))
                    .isExactlyInstanceOf(InvalidNameException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 null이거나 공백일 수 없습니다.");
        }

        @Test
        @DisplayName("null이면 예외를 발생한다")
        void 실패_이름생성_null() {
            // Given
            String name = null;

            // When & Then
            assertThatThrownBy(() -> new Name(name))
                    .isExactlyInstanceOf(InvalidNameException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 null이거나 공백일 수 없습니다.");
        }
    }
}
