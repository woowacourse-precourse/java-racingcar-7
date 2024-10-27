package racingcar.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.util.RaceAttemptNumberValidatorErrorMessages;

import static org.junit.jupiter.api.Assertions.*;

public class RaceAttemptNumberInputTest {

    @Test
    @DisplayName("정상적인 시도 횟수를 입력 테스트")
    void 정상적인_시도_횟수를_입력() {
        // given
        String input = "5";

        // when, then
        assertDoesNotThrow(() -> new RaceAttemptNumberInput().process(input));
    }

    @Test
    @DisplayName("입력된 시도 횟수가 0이거나 음수일 경우 예외 발생 테스트")
    void 입력된_시도_횟수가_0이거나_음수일_경우_예외_발생() {
        // given
        String input = "-1";

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new RaceAttemptNumberInput().process(input));
        assertEquals(RaceAttemptNumberValidatorErrorMessages.NUMBER_TOO_LOW.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력된 시도 횟수가 8일 경우 예외 발생 테스트")
    void 입력된_시도_횟수가_0일_경우_예외_발생() {
        // given
        String input = "0";

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new RaceAttemptNumberInput().process(input));
        assertEquals(RaceAttemptNumberValidatorErrorMessages.NUMBER_TOO_LOW.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력된 시도 횟수가 숫자가 아닐 경우 예외 발생 테스트")
    void 입력된_시도_횟수가_숫자가_아닐_경우_예외_발생() {
        // given
        String input = "abc";

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new RaceAttemptNumberInput().process(input));
        assertEquals(RaceAttemptNumberValidatorErrorMessages.INVALID_NUMBER_FORMAT.getMessage(), exception.getMessage());
    }
}