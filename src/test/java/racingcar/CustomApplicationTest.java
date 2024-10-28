package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CustomApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void Rounds3Test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void CarNameTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c,d", "1");
                    assertThat(output()).contains("a : ", "b : ", "c : -", "d : ", "최종 우승자 : c");
                },
                STOP, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void MixTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("qwe,asd,zxc", "3");
                    assertThat(output()).contains("qwe : --", "asd : --", "zxc : -", "최종 우승자 : qwe,asd");
                },
                STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
