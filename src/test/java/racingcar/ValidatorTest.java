package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 자동차_이름이_5자_초과시_예외발생() {
        List<String> carNames = Arrays.asList("pobiwoni,jun");

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames(carNames);
        });
    }

    @Test
    void 시행_횟수_입력이_잘못된_값인_경우_예외발생() {
        String input = "-1";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateAttemptCount(input);
        });
    }
}
