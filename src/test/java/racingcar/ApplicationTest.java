package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    void 자동차_이름_콤마_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("마지막 자동차이름 없을 경우")
    void 자동차_이름_없음1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("처음 자동차이름 없을 경우")
    void 자동차_이름_없음2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,woni,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 실행_횟수_0번() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 실행_횟수_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
