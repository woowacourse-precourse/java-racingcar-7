package racingcar.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    public static final String VALID_CAR_NAMES = "pobi,woni,jjj";
    public static final String EMPTY_STRING = "";

    @Test
    @DisplayName("게임이 정상적인 입력으로 실행되고 단일 우승자가 출력된다.")
    void gameRunsAndSingleWinnerIsDisplayed() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(VALID_CAR_NAMES, "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "jjj : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    @DisplayName("여러 번의 시도에서 다수의 우승자가 나와도 예외가 발생하지 않는다.")
    void gameRunsAndMultipleWinnersAreDisplayed() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(VALID_CAR_NAMES, "6");
                    assertThat(output()).contains("pobi : ------", "woni : ------", "jjj : ---", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차 이름에 공백이 포함된 경우 IllegalArgumentException이 발생한다.")
    void throwsExceptionForCarNamesWithSpaces() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni, jjj", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열일 경우 IllegalArgumentException이 발생한다.")
    void throwsExceptionForEmptyCarNames() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(EMPTY_STRING, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 빈 문자열일 경우 IllegalArgumentException이 발생한다.")
    void throwsExceptionForEmptyAttempts() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(VALID_CAR_NAMES, EMPTY_STRING))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 0일 경우 IllegalArgumentException이 발생한다.")
    void throwsExceptionForZeroAttempts() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(VALID_CAR_NAMES, "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 음수일 경우 IllegalArgumentException이 발생한다.")
    void throwsExceptionForNegativeAttempts() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(VALID_CAR_NAMES, "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 중복되는 경우 IllegalArgumentException이 발생한다.")
    void throwsExceptionForDuplicateCarNames() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,jjj", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 최대 길이(5자)를 초과할 경우 IllegalArgumentException이 발생한다.")
    void throwsExceptionForCarNameExceedingMaxLength() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,making", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차가 움직이지 않았다면, 모든 자동차가 우승자로 출력된다.")
    void noWinnersIfAllCarsStop() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(VALID_CAR_NAMES, "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "jjj : ", "최종 우승자 : pobi, woni, jjj");
                },
                STOP, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}