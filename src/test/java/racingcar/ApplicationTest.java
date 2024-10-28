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
    void 기능_테스트_1회_경주() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 기능_테스트_다회_경주() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni,jun", "2");
            assertThat(output()).contains("pobi : -", "woni : --", "jun : ").contains("최종 우승자 : woni");
        }, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP);
    }

    @Test
    void 예외_테스트_잘못된_자동차_이름() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름은 1자 이상 5자 이하여야 합니다."));
    }

    @Test
    void 예외_테스트_잘못된_시도_횟수() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", "0")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("시도 횟수는 1 이상이어야 합니다."));
    }

    @Test
    void 최종_우승자_공동_우승_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni,jun", "1");
            assertThat(output()).contains("pobi : -", "woni : -", "jun : -", "최종 우승자 : pobi, woni, jun");
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
