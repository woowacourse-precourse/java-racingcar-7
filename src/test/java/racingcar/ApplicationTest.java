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
    void 여러대의_자동차_다중_시도_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "3");
                assertThat(output()).contains(
                    "pobi : -",  // 1차 시도
                    "woni : -",  // 1차 시도
                    "jun : ",    // 1차 시도

                    "pobi : --", // 2차 시도
                    "woni : --", // 2차 시도
                    "jun : -",   // 2차 시도
                    
                    "pobi : ---",// 3차 시도
                    "woni : ---",// 3차 시도
                    "jun : --",  // 3차 시도
                    "최종 우승자 : pobi, woni" // 공동 우승자
                );
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP, // 1차 시도 (pobi: 전진, woni: 전진, jun: 멈춤)
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, // 2차 시도 (모두 전진)
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD  // 3차 시도 (모두 전진)
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
