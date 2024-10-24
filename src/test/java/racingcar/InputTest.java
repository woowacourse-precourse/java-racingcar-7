package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class InputTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void splitInputTest() {
        assertSimpleTest(
            () -> {
                String input = "alpha,bravo,cake";
                ArrayList<String> result = Input.splitInput(input);

                ArrayList<String> expected = new ArrayList<String>();
                expected.add("alpha");
                expected.add("bravo");
                expected.add("cake");

                assertThat(result).isEqualTo(expected);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
