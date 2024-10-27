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
    @DisplayName("정상적인 이름 넣었을 때 잘 돌아가는지 확인")
    void 기능_테스트_case1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("이름 앞뒤로 공백을 입력했을 때 잘 돌아가는지 확인")
    void 기능_테스트_case2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("6글자 이상 이름 예외처리")
    void 예외_테스트_case1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("앞뒤 공백 제외 6글자 이상 이름 예외처리")
    void 예외_테스트_case2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,   javaji   ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("round에 문자를 입력할 경우 예외처리")
    void 예외_테스트_case3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "i"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("round에 0을 입력할 경우 예외처리")
    void 예외_테스트_case4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("round에 음수를 입력할 경우 예외처리")
    void 예외_테스트_case5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("round에 소수를 입력할 경우 예외처리")
    void 예외_테스트_case6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "1.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}