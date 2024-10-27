package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1", "2", "54", "100"})
    void number(String number) {
        NumberValidator.validateIsNumber(number);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "a1"})
    void not_number(String number) {
        Assertions.assertThatThrownBy(() -> NumberValidator.validateIsNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "51", "100"})
    void positive(String number) {
        NumberValidator.validateIsPositive(number);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-10", "-1", "0"})
    void not_positive(String number) {
        Assertions.assertThatThrownBy(() -> NumberValidator.validateIsPositive(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}