package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setup() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", " ", "aaaaaa"})
    void 자동차_이름에_공백만_또는_길이초과_에러(String carName) {
        assertThatThrownBy(() -> inputValidator.validateCarNameLength(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 시도_횟수_0이하_int형초과_에러(int num) {
        assertThatThrownBy(() -> inputValidator.validateTryCountGreaterZero(num))
                .isInstanceOf(IllegalArgumentException.class);
    }
}