package racingcar.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import racingcar.Application;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarActionTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 모든_자동차_멈춤_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "jun : ", "최종 우승자 : pobi, woni, jun");
                },
                STOP, STOP, STOP
        );
    }

    @Test
    void 모든_자동차_이동_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : -", "최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
