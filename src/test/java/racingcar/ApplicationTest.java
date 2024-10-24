package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void function() {
        assertThat(RacingCar.splitParticipants("pobi,woni")).contains("pobi", "woni");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCar.validInput(new String[]{"pobi, bee9827", "1"}))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCar.validInput(new String[]{"pobi, woni", "A"}))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "0");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP
        );
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni, yong", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "yong : -", "최종 우승자 : pobi, woni, yong");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni, yong", "2");
                    assertThat(output()).contains(
                            "pobi : -", "woni : -", "yong : -",
                            "pobi : --", "woni : --", "yong : -",
                            "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP
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
