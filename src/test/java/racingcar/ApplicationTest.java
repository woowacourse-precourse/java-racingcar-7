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
    void 전진숫자가_유효하지않는_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    // 입력값: 자동차 이름과 시도 횟수
                    run("pobi,woni,jun", "3");

                    // 예상 결과 검증
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : -",
                            "pobi : --", "woni : -", "jun : --",
                            "pobi : ---", "woni : --", "jun : ---",

                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, ERROR_NUM, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
