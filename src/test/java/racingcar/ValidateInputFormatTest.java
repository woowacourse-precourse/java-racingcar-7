package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateInputFormatTest {

    @Test
    void 앞뒤에_컴마가_없는_경우_올바른_입력입니다() {
        // given
        String validInput = "yuze,woodz,jason";

        // when
        InputValidator inputValidator = new InputValidator();
        Boolean result = inputValidator.isValidInputFormat(validInput);

        // then
        assertTrue(result);
    }

    @Test
    void 앞뒤에_컴마가_존재하면_올바르지않은_입력입니다() {
        // given
        String startAndEndWithComma = ",,yuze,woodz,jason,,";

        // when
        InputValidator inputValidator = new InputValidator();

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isValidInputFormat(startAndEndWithComma);
        });
    }

    @Test
    void 앞에_컴마가_존재하면_올바르지않은_입력입니다() {
        // given
        String startWithComma = ",yuze,woodz,jason";

        // when
        InputValidator inputValidator = new InputValidator();

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isValidInputFormat(startWithComma);
        });
    }

    @Test
    void 뒤에_컴마가_존재하면_올바르지않은_입력입니다() {
        // given
        String endWithComma = "yuze,woodz,jason,";

        // when
        InputValidator inputValidator = new InputValidator();

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isValidInputFormat(endWithComma);
        });
    }
}