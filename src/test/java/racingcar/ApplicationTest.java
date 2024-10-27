package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 단독_우승_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains("pobi : -", "woni : ", "jun : ", "pobi : -", "woni : -", "jun : ",
                            "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, STOP, STOP, MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
