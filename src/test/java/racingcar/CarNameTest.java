package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Message.ErrorMessage;

class CarNameTest extends NsTest {

    @Test
    void 글자수_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("javaji1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.ERROR_MESSAGE_LENGTH)
        );
    }

    @Test
    void 빈값_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.ERROR_MESSAGE_BLANK)
        );
    }

    @Test
    void 특수문자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car@1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.ERROR_MESSAGE_INVALID_CHARACTER)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
