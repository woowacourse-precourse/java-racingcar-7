package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트_단일_라운드() {
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
    void 기능_테스트_다중_라운드() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains(
                            "pobi : -", "woni : -", "jun : -",
                            "pobi : --", "woni : -", "jun : --",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
