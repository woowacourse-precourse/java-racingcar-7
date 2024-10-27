package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.infrastructure.constant.Boundary;

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
    @DisplayName("실행 횟수로 음수는 입력할 수 없다.")
    void 음수는_입력할_수_없다() {
        // given
        final String input = "pobi, java";
        final String repeat = "-1";

        // when & then
        assertThatThrownBy(() -> runException(input, repeat))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행 횟수는 주어진 범위를 초과하면 안된다.")
    void 실행_가능_범위_초과를_확인할_수_있다() {
        // given
        final String input = "pobi, java";
        final String exceed = String.valueOf(Boundary.REPEAT_MAX + 1);

        // when & then
        assertThatThrownBy(() -> runException(input, exceed))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
