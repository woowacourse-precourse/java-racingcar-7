package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void validNameLengthTest() {
        assertSimpleTest(
                () -> {
                    String name = "ab1^*";
                    Validate.checkName(name);
                }
        );
    }

    @Test
    void validNameLengthExceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    String name = "q    1"; // length 6
                    Validate.checkName(name);
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
