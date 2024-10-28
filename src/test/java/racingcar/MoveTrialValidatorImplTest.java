package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.validator.trial.MoveTrialValidatorImpl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveTrialValidatorImplTest {

    private final MoveTrialValidatorImpl validator = new MoveTrialValidatorImpl();

    @Test
    public void validate_ShouldThrowException_WhenTrialInputIsNotNumeric() {
        String trialInputString = "abc";

        assertThatThrownBy(() -> validator.valdate(trialInputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 시도 횟수 입력");
    }

    @Test
    public void validate_ShouldNotThrowException_WhenTrialInputIsNumeric() {
        String trialInputString = "5";

        Assertions.assertDoesNotThrow(() -> validator.valdate(trialInputString)); // 예외가 발생하지 않으면 테스트 통과
    }
}
