package racingcar.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.view.ErrorMessage;

public class RawCarNamesValidatorTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차의_이름이_하나인_경우() {
        assertRandomNumberInRangeTest(() -> validateSingleCarName("pobi", "1"), MOVING_FORWARD, STOP);
    }

    private void validateSingleCarName(String input, String expected) {
        run(input, expected);
        assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
    }

    @Test
    void 입력된_문자열이_null인_경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException(null, ErrorMessage.NO_INPUT));
    }

    @Test
    void 입력된_문자열이_빈_문자열인_경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException("\n", ErrorMessage.NO_INPUT));
    }

    private void assertIllegalArgumentException(String input, ErrorMessage errorMessage) {
        assertThatThrownBy(() -> runException(input, "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
