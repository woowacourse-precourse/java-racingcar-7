package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void 시도_횟수_숫자로_변경_불가() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateTryCount("a"))
                .withMessageMatching("시도 횟수는 아라비아 숫자로 입력해야 합니다");
    }
}
