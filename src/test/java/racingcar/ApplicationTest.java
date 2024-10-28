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
    void 예제_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains(
                            "pobi : -",   // 1차 결과
                            "woni : ",    // 1차 결과
                            "jun : -",    // 1차 결과
                            "pobi : --",  // 2차 결과
                            "woni : -",   // 2차 결과
                            "jun : --",   // 2차 결과
                            "pobi : ---", // 3차 결과
                            "woni : --",  // 3차 결과
                            "jun : ---",  // 3차 결과
                            "pobi : ----",// 4차 결과
                            "woni : ---", // 4차 결과
                            "jun : ----", // 4차 결과
                            "pobi : -----", // 5차 결과
                            "woni : ----", // 5차 결과
                            "jun : -----", // 5차 결과
                            "최종 우승자 : pobi, jun"  // 최종 우승자 출력
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,  // 1차: pobi와 jun만 이동
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,  // 2차: 모두 이동
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,  // 3차: 모두 이동
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,  // 4차: 모두 이동
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD  // 5차: 모두 이동
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
