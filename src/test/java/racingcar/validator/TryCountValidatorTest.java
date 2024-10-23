package racingcar.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountValidatorTest {
    private final TryCountValidator tryCountValidator = new TryCountValidator();

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 시도_횟수_0이하_int형초과_에러(int num) {
        assertThatThrownBy(() -> tryCountValidator.validateTryCountGreaterZero(num))
                .isInstanceOf(IllegalArgumentException.class);
    }
}