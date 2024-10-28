package racingcar.inputvalidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.InputValidator;

class ValidateNameTest {
    private InputValidator inputValidator;
    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 컴마를_이름에_포함하지_않으면_올바른_입력입니다() {
        // given
        String validInput = "yuze,woodz,jason";

        // when
        Boolean result = inputValidator.isValidName(validInput);

        // then
        assertTrue(result);
    }

    @Test
    void 숫자를_이름에_포함할_수_있습니다() {
        // given
        String validInput = "yu1ze,woodz,2jon";

        // when
        Boolean result = inputValidator.isValidName(validInput);

        // then
        assertTrue(result);
    }

    @Test
    void 공백을_이름에_포함할_수_있습니다() {
        // given
        String validInput = "yu ze,woodz,jason";

        // when
        Boolean result = inputValidator.isValidName(validInput);

        // then
        assertTrue(result);
    }

    @Test
    void 컴마가_아닌_기호를_이름에_포함할_수_있습니다() {
        // given
        String validInput = "yu.ze,woodz,jon~";

        // when
        Boolean result = inputValidator.isValidName(validInput);

        // then
        assertTrue(result);
    }

    @Test
    void 컴마가_이름에_포함되면_올바르지않은_입력입니다() {
        // given
        String invalidInput = "yuze,w,,oodz,jason";

        // then
        assertThrows(IllegalArgumentException.class, () -> inputValidator.isValidName(invalidInput));
    }
}