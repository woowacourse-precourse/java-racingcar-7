package racingcar.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.view.ErrorMessage;

public class MovingCountValidatorTest extends NsTest {

    @Test
    void 입력된_문자열이_null인_경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException(null, ErrorMessage.NO_INPUT.getMessage()));
    }

    @Test
    void 입력된_문자열이_빈_문자열인_경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException("\n", ErrorMessage.NO_INPUT.getMessage()));
    }

    @Test
    void 입력_받은_이동_횟수가_long의_범위가_아닌경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException(Long.MAX_VALUE + "1",
                ErrorMessage.TOO_MANY_MOVING_COUNT.getMessage()));
    }

    @Test
    void 입력_받은_이동_횟수가_음수인_경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException("-3", ErrorMessage.NEGATIVE_MOVING_COUNT.getMessage()));
    }

    @Test
    void 입력_받은_이동_횟수가_소수인_경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException("3.1", ErrorMessage.DECIMAL_MOVING_COUNT.getMessage()));
    }

    @Test
    void 입력_받은_이동_횟수가_숫자가_아닌_경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException("a", ErrorMessage.INVALID_MOVING_COUNT.getMessage()));
    }

    private void assertIllegalArgumentException(String input, String expectedMessage) {
        assertThatThrownBy(() -> runException("kim, lee", input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
