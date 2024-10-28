package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

class ValidatorTest {

    @Test
    void validateCarNames_validNames() {
        List<String> validNames = Arrays.asList("hi", "im", "tube");
        Assertions.assertThatCode(() -> Validator.validateCarNames(validNames))
                .doesNotThrowAnyException();
    }

    @Test
    void validateCarNames_invalidName() {
        List<String> invalidNames = Arrays.asList("hi", "mynameis", "tube");
        Assertions.assertThatThrownBy(() -> Validator.validateCarNames(invalidNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void validateRaceCount_validCounts(int count) {
        Assertions.assertThatCode(() -> Validator.validateRaceCount(count))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -5})
    void validateRaceCount_invalidCounts(int count) {
        Assertions.assertThatThrownBy(() -> Validator.validateRaceCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

}