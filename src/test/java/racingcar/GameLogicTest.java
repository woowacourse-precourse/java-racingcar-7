package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameLogicTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 우승자가_1명인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,lucku", "2");
                    assertThat(output()).contains("pobi : --", "woni : ", "lucku : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 우승자가_여러_명인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,lucku", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "lucku : -", "최종 우승자 : pobi, woni, lucku");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 단일_참가자가_우승하는_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
