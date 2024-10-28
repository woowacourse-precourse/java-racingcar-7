package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidateTest {
    @Test
    void validateCarNames_successTest() {
        // given
        String carNamesInput = "jeong,hun";

        // when
        String[] carNames = Validate.validateCarNames(carNamesInput);

        // then
        assertThat(carNames).isEqualTo(new String[] {"jeong", "hun"});
    }

    @Test
    void validateTryNumber_successTest() {
        // given
        String tryNumberInput = "2";

        // when
        int tryNumber = Validate.validateTryNumber(tryNumberInput);

        // then
        assertThat(tryNumber).isEqualTo(2);
    }
}