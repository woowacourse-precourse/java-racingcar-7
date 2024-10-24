package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    public void 입력이_없는_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean hasInput = inputValidator.hasNoInput("");

        Assertions.assertThat(hasInput).isFalse();
    }

}