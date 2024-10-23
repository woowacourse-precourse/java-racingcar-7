package racingcar.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarNameValidatorTest {
    private final CarNameValidator carNameValidator = new CarNameValidator();

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", " ", "aaaaaa"})
    void 자동차_이름에_공백만_또는_길이초과_에러(String carName) {
        assertThatThrownBy(() -> carNameValidator.validateCarNameLength(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}