package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CarNameTest extends NsTest {

    @Test
    void 글자수_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("javaji1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈값_테스트() {
        assertThatThrownBy(() -> runException(" "))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});

    }
}
