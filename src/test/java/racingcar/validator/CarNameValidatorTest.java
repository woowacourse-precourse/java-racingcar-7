package racingcar.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarNameValidatorTest {
    private final CarNameValidator carNameValidator = new CarNameValidator();

    @Test
    void 자동차_이름_길이초과_에러() {
        assertThatThrownBy(() -> carNameValidator.validateCarNameLength("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}