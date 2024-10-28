package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.trial.MoveTrialValidatorImpl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveTrialValidatorImplTest {

    private final MoveTrialValidatorImpl validator = new MoveTrialValidatorImpl();

    @DisplayName("입력한 시도 횟수가 숫자 문자열이 아닐 떄 IllegalArgumentException 이 발생하는지 Test")
    @Test
    public void validate_ShouldThrowException_WhenTrialInputIsNotNumeric() {
        String trialInputString = "abc";

        assertThatThrownBy(() -> validator.valdate(trialInputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 시도 횟수 입력");
    }

    @DisplayName("입력한 시도 횟수가 정상적으로 유효성 검사를 통과하는지 Test")
    @Test
    public void validate_ShouldNotThrowException_WhenTrialInputIsNumeric() {
        String trialInputString = "5";

        Assertions.assertDoesNotThrow(() -> validator.valdate(trialInputString)); // 예외가 발생하지 않으면 테스트 통과
    }
}
