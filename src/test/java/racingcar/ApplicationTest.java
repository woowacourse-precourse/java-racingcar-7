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
    @DisplayName("자동차 이름이 없는 경우")
    void 자동차_이름_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("이동 횟수 입력이 음수인 경우")
    void 이동_횟수_음수_또는_0_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi, java", "-1"))
                .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, java", "0"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("이동 횟수 입력이 Integer 범위를 초과하는 경우")
    void 이동_횟수_초과_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi, java", "9999999999"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("우승자가 여러 명인 경우")
    void 여러_명의_우승자_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
