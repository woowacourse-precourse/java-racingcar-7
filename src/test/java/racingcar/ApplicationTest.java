package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @BeforeEach
    void setUp() {
        Application.carScores = new HashMap<>();
        Application.cars = new String[]{};
        Application.repeat = 0;
    }

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 우승자가_한명인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : --", "woni : ", "jun : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, STOP
        );
    }

    @Test
    void 우승자가_여러명인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : --", "woni : -", "jun : --", "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자가_모두인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : --", "woni : --", "jun : --", "최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
