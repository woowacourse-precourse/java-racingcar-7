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
    void 자동차_이름_입력_테스트() {
        run("pobi,woni", "1");
        assertThat(output()).contains("pobi : ", "woni : ");
    }

    @Test
    void 시도_횟수_입력_테스트() {
        run("pobi,woni", "3");
        assertThat(output()).contains("pobi : ", "woni : ");
    }

    @Test
    void 자동차_이동_로직_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 최종_우승자_발표_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("최종 우승자 : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 잘못된_자동차_이름_입력_테스트() {
        assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하이어야 합니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
