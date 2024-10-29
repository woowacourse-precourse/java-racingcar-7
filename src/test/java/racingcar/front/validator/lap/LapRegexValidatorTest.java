package racingcar.front.validator.lap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.front.exception.UnNecessaryCharIncludedException;
import racingcar.app.front.validator.lap.LapRegexValidator;

public class LapRegexValidatorTest {

    private final LapRegexValidator validator = LapRegexValidator.initiate();

    @Test
    @DisplayName("숫자 이외의 문자열을 입력한 경우")
    void unNecessaryCharIncluded() {
        // given
        String source = "A";
        // when & then
        assertThrows(
                UnNecessaryCharIncludedException.class,
                () -> validator.check(source)
        );
    }

    @Test
    @DisplayName("앞에 000있는 경우")
    void leadingZeroExistCase1() {
        // given
        String source = "0001";
        // when & then
        assertDoesNotThrow(
                () -> validator.check(source)
        );
    }

    @Test
    @DisplayName("앞에 0있는 경우")
    void leadingZeroExist() {
        // given
        String source = "0";
        // when & then
        assertThrows(
                UnNecessaryCharIncludedException.class,
                () -> validator.check(source)
        );
    }
}
