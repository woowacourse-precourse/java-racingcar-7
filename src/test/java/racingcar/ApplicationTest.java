package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트_한명이_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_동시_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hun", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_전원_우승_전부_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hun", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "hun : -", "최종 우승자 : hun, pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_전원_우승_전부_전진실패() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hun", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "hun : ", "최종 우승자 : hun, pobi, woni");
                },
                STOP, STOP, STOP
        );
    }

    @Test
    void 기능_테스트_자동차_이름_구분을_쉼표로_사용하지않음() {
        System.out.println("자동차 이름 구분자로 쉼표가 아닌 문자를 사용했을 때는 '.'도 이름으로 판단");
        assertRandomNumberInRangeTest(
                () -> {
                    run("po.bi,woni,hun", "1");
                    assertThat(output()).contains("po.bi : -", "woni : ", "hun : ", "최종 우승자 : po.bi");
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 기능_테스트_자동차_이름_앞에_공백() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" pobi,woni,      hun", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "hun : -", "최종 우승자 : hun");
                },
                STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_자동차_이름_뒤에_공백() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" pobi,woni,hun      ", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "hun : -", "최종 우승자 : hun");
                },
                STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_자동차_이름_앞_뒤에_공백() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" pobi,woni,  hun  ", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "hun : -", "최종 우승자 : hun");
                },
                STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_매_차수마다_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : ", "pobi : --", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트_자동차_이름이_5글자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름이_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시행_횟수가_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시행_횟수가_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름이_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름이_빈_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름이_개행문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,\n,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름_구분을_쉼표로_사용하지않음() {
        System.out.println("자동차 이름 구분자로 쉼표가 아닌 문자를 사용했을 때는 '.'도 이름으로 판단");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi.woni,hun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_시행_횟수가_정수가_아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "hun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
