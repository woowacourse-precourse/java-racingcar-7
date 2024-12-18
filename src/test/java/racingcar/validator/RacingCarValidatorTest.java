package racingcar.validator;

import static racingcar.validator.ErrorMessage.CAR_NAME_LENGTH_ERROR;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarValidatorTest {
    private RacingCarValidator racingCarValidator;

    @BeforeEach
    void setUp() {
        racingCarValidator = new RacingCarValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"p", "pobib"})
    void 이름_길이가_올바른_이름을_받는다(String input) {
        racingCarValidator.validateCarName(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobibi"})
    void 이름_길이가_범위를_벗어날_경우_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> racingCarValidator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_ERROR.getMessage());
    }
}