package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

class RacingTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,eqq,qwe", "10");
                    assertThat(output()).contains("pobi : -", "woni : ", "eqq : ", "qwe : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

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
