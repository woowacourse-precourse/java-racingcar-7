package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void 콤마로_split_할_수_없음() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateCarNames("pobi:nana,jun"))
                .withMessageMatching("자동차 이름은 콤마로 구분해야 합니다");
    }

    @Test
    void 시도_횟수_숫자로_변경_불가() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateTryCount("a"))
                .withMessageMatching("시도 횟수는 아라비아 숫자로 입력해야 합니다");
    }
}
