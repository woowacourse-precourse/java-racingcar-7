package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트_자동차_이름과_시도횟수_정상입력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 결과:", "우승자:");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_자동차_이름_최대_길이() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2,car3,car4,car5", "2");
                    assertThat(output()).contains("car1 : -", "car2 : ", "car3 : ", "car4 : ", "car5 : ", "최종 결과:");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_자동차_이름_5자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi1234,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기능_테스트_시도횟수_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기능_테스트_시도횟수_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름_빈문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_자동차_이름_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기능_테스트_우승자_결정() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "5");
                    assertThat(output()).contains("최종 결과:", "우승자:");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_여러자동차_동시_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,javaji", "5");
                    assertThat(output()).contains("최종 결과:", "우승자:");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_랜덤_이동_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2", "10");
                    assertThat(output()).contains("car1 : ", "car2 : ", "최종 결과:");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
