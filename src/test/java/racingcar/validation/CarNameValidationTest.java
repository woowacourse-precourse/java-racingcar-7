package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarNameValidationTest {
    @Test
    void validate_자동차_이름_길이_5_이하_검증() {
        String input = "pobi";
        String inputOverLimit = "wooooni";

        boolean inputResult = CarNameValidation.validateCarNameLength(input);
        boolean inputOverLimitResult = CarNameValidation.validateCarNameLength(inputOverLimit);

        assertThat(inputResult).isFalse();
        assertThat(inputOverLimitResult).isTrue();
    }
}
