package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class MyApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 내_기능_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi : ----", "woni : ----", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 내_기능_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP
        );
    }

    @Test
    void 내_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "hi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}