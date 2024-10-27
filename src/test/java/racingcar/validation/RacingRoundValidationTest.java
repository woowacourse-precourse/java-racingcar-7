package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingRoundValidationTest {
    @Test
    void validate_라운드_양수_검증() {
        Integer input = 3;
        Integer inputNotPositiveNumber = -1;

        boolean inputResult = RacingRoundValidation.validateRacingRoundNumberRange(input);
        boolean inputNotPositiveNumberResult = RacingRoundValidation.validateRacingRoundNumberRange(
                inputNotPositiveNumber);

        assertThat(inputResult).isFalse();
        assertThat(inputNotPositiveNumberResult).isTrue();
    }
}
