package racingcar.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarValidatorTest {

    private final RacingCarValidator racingCarValidator = new RacingCarValidator();

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_예외_발생(String inputString) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> racingCarValidator.validateRounds(inputString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"jewan", "*"})
    void 숫자가_아닌_문자열_예외_발생(String inputString) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> racingCarValidator.validateRounds(inputString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "101"})
    void 범위_초과_예외_발생(String inputString) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> racingCarValidator.validateRounds(inputString));
    }
}
