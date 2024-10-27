package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("자동차 이름이 없는 경우 예외 테스트")
    void testEmptyRacingCarName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("자동차 이름이 빈 값으로 끝나는 경우 테스트")
    void testRacingCarNameEndingWithComma() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과인 경우 예외 발생 테스트")
    void testRacingCarNameExceedsLimit() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1car2", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닌 경우 예외 발생 테스트")
    void testInvalidRaceCountNotANumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1, car2", "a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("시도 횟수가 0 이하인 경우 예외 발생 테스트")
    void testInvalidRaceCountLessThanOrEqualToZero() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1, car2", "0"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
