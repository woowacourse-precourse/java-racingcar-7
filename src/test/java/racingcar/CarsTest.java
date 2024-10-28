package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Message.ErrorMessage;

class CarsTest extends NsTest {
    @Test
    void 중복_이름_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car,car"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.ERROR_MESSAGE_DUPLICATE_NAME)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
