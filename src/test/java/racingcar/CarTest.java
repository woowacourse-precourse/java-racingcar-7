package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class WinnerTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("공동 우승자가 여러명인데 한명만 나올 경우")
    void 공동우승자_명수_오류() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    @DisplayName("단독 우승자가 한명인데 여러명 나올 경우")
    void 단독우승자_명수_오류() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("최종 우승자 : pobi,woni");
        }, MOVING_FORWARD, STOP);
    }

    @Override
    protected void runMain() {

    }
}

