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
    void 기능_테스트_단독_우승자() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_공동_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,java", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_움직이지_않은_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,java", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, woni, java");
                },
                STOP, STOP, STOP
        );
    }

    @Test
    void 예외_테스트_입력값_길이_초과() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력값_공백_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
