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
    @DisplayName("race 기능이 작동한다.")
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    @DisplayName("공동 우승자를 뽑는 race 기능이 작동한다.")
    void 기능_공동우승_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    @DisplayName("이름이 5자 이상일 때 IllegalArgumentException을 throw한다.")
    void 이름_5자이상_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    @DisplayName("횟수가 0번일 때 IllegalArgumentException을 throw한다.")
    void 횟수_0번일_때_공동우승_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaj", "0")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    @DisplayName("입력 횟수가 0보다 작을 때 IllegalArgumentException을 throw한다.")
    void 횟수_음수_입력_예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaj", "-1")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
