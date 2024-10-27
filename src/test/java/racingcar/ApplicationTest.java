package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차 2대, 시도 횟수 1회인 경우")
    void case1() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("자동차 3대, 시도 횟수 1회인 경우")
    void case2() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,kia", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "kia : -",
                    "최종 우승자 : pobi, kia");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차 2대, 시도 횟수 2회인 경우")
    void case3() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "2");
                assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("예외: 자동차 이름이 5자 이상인 경우")
    void errorCase1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다. ")
        );
    }

    @Test
    @DisplayName("예외: 자동차 이름이 중복된 경우")
    void errorCase2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji, pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름을 입력할 수 없습니다. ")
        );
    }

    @Test
    @DisplayName("예외: 자동차 이름이 공백인 경우")
    void errorCase3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,,java", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백이 될 수 없습니다. ")
        );
    }

    @Test
    @DisplayName("예외: 시도 횟수가 숫자가 아닌 경우")
    void errorCase4() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java", "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 숫자만 입력 가능합니다. ")
        );
    }

    @Test
    @DisplayName("예외: 시도 횟수가 음수인 경우")
    void errorCase5() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java", "-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 양수만 입력 가능합니다.")
        );
    }

    @Test
    @DisplayName("예외: 시도 횟수가 0인 경우")
    void errorCase6() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 양수만 입력 가능합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
