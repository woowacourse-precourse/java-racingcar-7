package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("기능_테스트_기본")
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
    @DisplayName("예외_테스트_자동차_이름_길이_초과")
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기능_테스트_단일_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun,soeun", "3");
                    assertThat(output()).contains("pobi : --", "woni : ", "jun : ---", "soeun : -", "최종 우승자 : jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
                STOP, STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_공동_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun,soeun", "3");
                    assertThat(output()).contains("pobi : --", "woni : -", "jun : ", "soeun : --",
                            "최종 우승자 : pobi, soeun");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP,
                STOP, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_모든_자동차_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun,soeun", "3");
                    assertThat(output()).contains("pobi : ", "woni : ", "jun : ", "soeun : ",
                            "최종 우승자 : pobi, woni, jun, soeun");
                },
                STOP, STOP, STOP, STOP,
                STOP, STOP, STOP, STOP,
                STOP, STOP, STOP, STOP
        );
    }

    @Test
    void 기능_테스트_시도_횟수_10번() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "10");
                    assertThat(output()).contains("pobi : ", "woni : ", "jun : ", "최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_자동차_이름_숫자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,123", "3");
                    assertThat(output()).contains("pobi : --", "woni : -", "123 : ---", "최종 우승자 : 123");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_자동차_이름_앞에_공백() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" pobi, woni, jun", "3");
                    assertThat(output()).contains("pobi : ---", "woni : -", "jun : --", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_자동차_이름_끝에_공백() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi ,woni ,jun ", "3");
                    assertThat(output()).contains("pobi : ---", "woni : -", "jun : --", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_자동차_이름_양끝에_공백() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" pobi , woni , jun ", "3");
                    assertThat(output()).contains("pobi : ---", "woni : -", "jun : --", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트_자동차_이름_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,woni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름_빈값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름_쉼표_시작() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름_중간에_빈값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름_중간에_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름_내_공백_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,w ni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_1대() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도_횟수_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도_횟수_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도_횟수_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도_횟수_특수_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "$"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시도_횟수_숫자_문자_특수_문자_혼합() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "3abc$"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
