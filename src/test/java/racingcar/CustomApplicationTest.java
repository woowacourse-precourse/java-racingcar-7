package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomApplicationTest {
    @Test
    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외 발생")
    void shouldThrowExceptionWhenCarNameExceedsLimit() {
        String input = "pobi,cronger,sujin";

        assertThatThrownBy(() -> Application.splitToCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름");
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있을 경우 예외 발생")
    void shouldThrowExceptionWhenDuplicateCarNames() {
        String input = "pobi,pobi,sujin";

        assertThatThrownBy(() -> Application.splitToCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름");
    }

    @Test
    @DisplayName("0 이하의 시도 횟수를 입력하면 예외 발생")
    void shouldThrowExceptionWhenZeroOrNegativeAttempts() {
        String input = "0";

        assertThatThrownBy(() -> Application.parseNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자");
    }

    @Test
    @DisplayName("최대 시도 횟수를 초과하는 입력 시 예외 발생")
    void shouldThrowExceptionWhenExceedsMaxAttempts() {
        String input = "1001";

        assertThatThrownBy(() -> Application.parseNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대 시도 횟수");
    }

    @Test
    @DisplayName("숫자가 아닌 입력 시 예외 발생")
    void shouldThrowExceptionWhenNonNumericInput() {
        String input = "ten";

        assertThatThrownBy(() -> Application.parseNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자");
    }
}
