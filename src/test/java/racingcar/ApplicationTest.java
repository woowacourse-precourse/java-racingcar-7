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

    @DisplayName("[정상 테스트]입력 횟수 0, 전원 공동 우승")
    @Test
    void Application_playZero_test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "0");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("[정상 테스트]공동 우승자")
    @Test
    void Application_jointWinner_test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : --", "woni : -", "jun : --", "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, STOP
        );
    }

    @DisplayName("[정상 테스트]전원 공동 우승자")
    @Test
    void Application_allWinner_test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : --", "woni : --", "jun : --", "최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("[예외 테스트] 이름이 빈 문자열")
    @Test
    void Application_emptyName_exception_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("[예외 테스트] 시행횟수가 음수")
    @Test
    void Application_negativeRound_exception_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("[예외 테스트] 시행횟수가 숫자가 아닌 문자형")
    @Test
    void Application_invalidRound_exception_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "asdf"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
