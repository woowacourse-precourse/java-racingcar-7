package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void inputEmptyAndCommaTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(",", "1");
                    assertThat(output()).contains("car(1) : -", "car(2) : ", "최종 우승자 : car(1)");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void inputSingleNameTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -", "car : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
