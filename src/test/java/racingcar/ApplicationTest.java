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
    void 여러_회_시도_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,cu", "3");
                    assertThat(output()).contains("pobi : -", "woni : ", "cu : ");
                    assertThat(output()).contains("최종 우승자 : ");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 단일_참가자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "2");
                    assertThat(output()).contains("pobi : ");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 입력값_형식_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
