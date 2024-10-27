package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingNumTest {

    private static final String NEGATIVE_NUMBER_ERROR = "시도할 횟수는 0보다 큰 정수이어야 합니다.";
    private static final String NON_INTEGER_ERROR = "시도할 횟수는 정수로 입력되어야 합니다.";

    @Test
    void 정상_기능_테스트() {
        // Given
        String input = "10";

        // When
        int result = RacingNum.numValid(input);

        // Then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 경계값_테스트() {
        // Given
        String input = "0";

        // Then
        assertThatThrownBy(() -> RacingNum.numValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_NUMBER_ERROR);
    }

    @Test
    void 음수_예외_테스트() {
        // Given
        String input = "-30";

        // Then
        assertThatThrownBy(() -> RacingNum.numValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_NUMBER_ERROR);
    }

    @Test
    void 문자_예외_테스트() {
        // Given
        String input = "10java";

        // Then
        assertThatThrownBy(() -> RacingNum.numValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_INTEGER_ERROR);
    }
}
