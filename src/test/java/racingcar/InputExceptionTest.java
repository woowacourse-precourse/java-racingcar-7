package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class InputExceptionTest extends NsTest {

    @Test
    void 시도횟수_음수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_문자_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "a"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi;javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
