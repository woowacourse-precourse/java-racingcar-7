package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Domain.MoveCount;
import racingcar.Message.ErrorMessage;

class MoveCountTest extends NsTest {

    @Test
    void 음수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new MoveCount("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
        );
    }

    @Test
    void 제로_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new MoveCount("0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.ERROR_MESSAGE_INVALID_MOVE_COUNT)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}