package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("단일 우승자 테스트")
    void 단일_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : -", "woni : --", "jun : ---", "최종 우승자 : jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, MOVING_FORWARD,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("공동 우승자 테스트")
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : -", "woni : --", "jun : --", "최종 우승자 : woni, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("전체 우승자 테스트")
    void 전체_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ---", "jun : ---", "최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("모든 자동차 정지 테스트")
    void 모든_자동차_정지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains("pobi : ", "woni : ", "jun : ", "최종 우승자 : pobi, woni, jun");
                },
                STOP, STOP, STOP
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"pobi,javaji", ",pobi", "pobi, "})
    void 예외_테스트_이름길이_예외(String inputCars) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(inputCars, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "a"})
    void 예외_테스트_시도횟수_예외(String inputRaceCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", inputRaceCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
