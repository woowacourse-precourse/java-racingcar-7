package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.HTMLDocument;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void input_error_글자수_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woowahan"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
    }

    @Test
    void input_error_시도횟수_1이하() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void input_error_시도횟수_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
