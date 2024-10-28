package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest extends NsTest {
    @Test
    void 예외_테스트_input_자동차_이름_6자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaaaaaa,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_input_자동차_이름_공백() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,,,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_input_시도_횟수_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "O"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_input_시도_횟수_0회() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
