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
    @DisplayName("자동차가 0대 생성 된 경우")
    void meetsCarCountZero_Then_Exception() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차의 이름이 5자를 초과할 경우")
    void meetsCarNameOverFive_Then_Exception() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("정상(1대 이상)적으로 생성 될 경우")
    void meetsCarCountOneOrMore_Then_Success() {
        assertSimpleTest(() -> {
            run("pobi", "1");
            assertThat(output()).contains("pobi : -");
        });
    }

    @Test
    @DisplayName("0번 횟수 동안 반복 할 경우 예외를 던짐")
    void meetsZeroRound_Then_Exception() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi", "0"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("음수 횟수를 반복 할 경우 예외를 던짐")
    void meetsMinusRound_Then_Exception() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("반복 횟수에 문자열이 들어 올 경우 예외를 던짐")
    void meetsStringRound_Then_Exception() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "hi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
