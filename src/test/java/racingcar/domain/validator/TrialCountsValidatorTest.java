package racingcar.domain.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

public class TrialCountsValidatorTest {
    private TrialCountsValidator trialCountsValidator;

    @BeforeEach
    void setUp() {
        trialCountsValidator = new TrialCountsValidator();
    }

    @Test
    void 숫자가_아닌_값이_들어오면_예외_발생() {
        //given
        String invalidInput = "a";
        //when
        try {
            trialCountsValidator.validate(invalidInput);
        } catch (IllegalArgumentException e) {
            assertThat("입력한 값은 숫자가 아닙니다 : " + invalidInput).isEqualTo(e.getMessage());
        }
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            trialCountsValidator.validate(invalidInput);
        });
    }

    @Test
    void 숫자가_0이면_예외_발생() {
        //given
        String zeroInput = "0";
        //when
        try {
            trialCountsValidator.validate(zeroInput);
        } catch (IllegalArgumentException e) {
            assertThat("입력한 값은 0보다 커야 합니다 : " + zeroInput).isEqualTo(e.getMessage());
        }
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            trialCountsValidator.validate(zeroInput);
        });
    }

    @Test
    void 숫자가_음수면_예외_발생() {
        //given
        String minusInput = "-1";
        //when
        try {
            trialCountsValidator.validate(minusInput);
        } catch (IllegalArgumentException e) {
            assertThat("입력한 값은 0보다 커야 합니다 : " + minusInput).isEqualTo(e.getMessage());
        }
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            trialCountsValidator.validate(minusInput);
        });
    }

    @Test
    void 올바른_숫자_값이_들어오면_정상_처리() {
        //given
        String validInput = "5";
        //when
        int result = trialCountsValidator.validate(validInput);
        //then
        assertEquals(5, result);
    }
}
