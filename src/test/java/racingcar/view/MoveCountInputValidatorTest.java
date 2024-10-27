package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCountInputValidatorTest {
    private final MoveCountInputValidator validator = new MoveCountInputValidator();

    @DisplayName("유효하지 않은 숫자가 입력된 경우 IllegalArgumentException 발생")
    @Test
    void invalidNumberThrowsException() {
        String input = "abc";

        assertThatThrownBy(() -> validator.validateMoveCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 숫자를 입력해야 합니다.");
    }

    @DisplayName("음수가 입력된 경우 IllegalArgumentException 발생")
    @Test
    void negativeNumberThrowsException() {
        String input = "-1";

        assertThatThrownBy(() -> validator.validateMoveCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 0 이상의 정수여야 합니다.");
    }

    @DisplayName("0 이상의 정수가 입력된 경우 정상적으로 이동 횟수 반환")
    @Test
    void validMoveCountReturnsValue() {
        String input = "5";

        int result = validator.validateMoveCount(input);

        assertThat(result).isEqualTo(5);
    }

    @DisplayName("정수 범위를 초과한 경우 IllegalArgumentException 발생")
    @Test
    void outOfRangeThrowsException() {
        String input = String.valueOf(Long.MAX_VALUE);

        assertThatThrownBy(() -> validator.validateMoveCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 정수 범위를 초과할 수 없습니다.");
    }

    @DisplayName("0이 입력된 경우 정상적으로 이동 횟수 반환")
    @Test
    void zeroMoveCountReturnsValue() {
        String input = "0";

        int result = validator.validateMoveCount(input);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("정수 최대값이 입력된 경우 정상적으로 이동 횟수 반환")
    @Test
    void maxIntMoveCountReturnsValue() {
        String input = String.valueOf(Integer.MAX_VALUE);

        int result = validator.validateMoveCount(input);

        assertThat(result).isEqualTo(Integer.MAX_VALUE);
    }

}
