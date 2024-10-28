package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트_단일_라운드() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_다중_라운드() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains(
                            "pobi : -", "woni : -", "jun : -",
                            "pobi : --", "woni : -", "jun : --",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_예외_테스트() {
        assertThatThrownBy(() -> RacingGame.validateCarNames(List.of("pobi", "javaji")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    void 이동_횟수_음수_예외_테스트() {
        assertThatThrownBy(() -> RacingGame.parseRounds("-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 0보다 커야 합니다.");
    }

        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
