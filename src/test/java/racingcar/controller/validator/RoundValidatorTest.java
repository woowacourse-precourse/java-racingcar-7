package racingcar.controller.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorBase;

class RoundValidatorTest extends ValidatorTest<Integer>{
    @Override
    protected Validator<Integer> getValidator() {
        return new RoundValidator();
    }

    @Test
    void 숫자로_된_라운드_수를_입력받는다() {
        String input = "5";

        Assertions.assertThat(getValidator().validate(input)).isEqualTo(5);
    }

    @Test
    void 문자가_포함된_입력을_받으면_예외를_발생시킨다() {
        String input = "five";

        assertThatThrownBy(() -> getValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorBase.ROUNDS_MUST_BE_NUMBER.getMessage());
    }

    @Test
    void 음수나_0을_입력받으면_예외를_발생시킨다() {
        String input = "-1";

        assertThatThrownBy(() -> getValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorBase.ROUNDS_COUNT_INVALID.getMessage());
    }

    @Test
    void 최대_라운드_수를_초과하면_예외를_발생시킨다() {
        String input = String.valueOf(RoundValidator.MAX_ROUNDS + 1);

        assertThatThrownBy(() -> getValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorBase.ROUNDS_COUNT_INVALID.getMessage());
    }
}