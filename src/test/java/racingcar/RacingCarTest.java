package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RacingCarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 실행횟수_값을_음수를_넣으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "oo"), "-1")
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름을_한개만_넣어도_정상적으로_우승자를_판별할_수_있다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}