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
    void 이름_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("  ,woni,jun"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.")
        );
    }

    @Test
    void 이동_횟수_음수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 이동 횟수는 1 이상의 정수여야 합니다.")
        );
    }

    @Test
    void 이동_횟수_문자열_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 숫자를 입력해야 합니다.")
        );
    }

    @Test
    void 다양한_자동차_경주_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun,javaj", "3");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : -",
                            "jun : -",
                            "javaj : -",
                            "최종 우승자 : pobi, woni, jun, javaj"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, STOP, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
