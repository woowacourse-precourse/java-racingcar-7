package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingTest extends NsTest {

    @Test
    void 자동차_개수_1개_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaa", "3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_개수_0개_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_이름_빈값_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도_개수_0회_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaa,bbb", "0"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도_개수_숫자_아닌_문자열_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaa,bbb", "a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
