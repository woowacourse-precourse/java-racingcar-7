package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 한명_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("poby,woni,jun", "1");
                    assertThat(output()).contains("poby : -", "woni : ", "jun : ", "최종 우승자 : poby");
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 두명_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("poby,woni,jun", "1");
                    assertThat(output()).contains("poby : -", "woni : -", "jun : ", "최종 우승자 : poby, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 세명_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("poby,woni,jun", "1");
                    assertThat(output()).contains("poby : -", "woni : -", "jun : -", "최종 우승자 : poby, woni, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void allCarsDoNotMoveTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("poby,woni,jun", "1");

                    String resultOutput = output();
                    assertThat(resultOutput).contains("poby : ", "woni : ", "jun : ");
                    assertThat(resultOutput).contains("최종 우승자 : poby, woni, jun");
                },
                STOP, STOP, STOP
        );
    }
}
