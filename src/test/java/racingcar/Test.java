package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Test extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @org.junit.jupiter.api.Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,ja v", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
