package racingcar.inputvalidator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.InputValidator;

class ValidateRoundTest {
    private InputValidator inputValidator;
    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 시도횟수가_숫자이면_올바른_입력입니다() {
        // when
        Integer result = inputValidator.isValidRound("58");

        // then
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(58);
    }

    @Test
    void 시도횟수로_문자가_올_수_없습니다() {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.isValidRound("57d");
        });
    }
}