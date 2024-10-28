package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.exception.CarNameSplitExceptionMessage.CAR_NAMES_LAST_COMMA;
import static racingcar.message.exception.CarNameSplitExceptionMessage.CAR_NAME_COUNT_IS_ONE;
import static racingcar.message.exception.CarNameSplitExceptionMessage.CAR_NAME_DUPLICATE;
import static racingcar.message.exception.CarNameSplitExceptionMessage.CAR_NAME_INCLUDE_SPECIAL_CHARACTERS;

import org.junit.jupiter.api.Test;

public class InputCarNameTest extends ApplicationTest {
    @Test
    void 공백_자동차_이름_예외() {
        assertThatThrownBy(() -> runException(",,", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_특수문자_포함() {
        assertThatThrownBy(() -> runException("pope,ki%%", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_INCLUDE_SPECIAL_CHARACTERS);
    }

    @Test
    void 자동차_이름_문자열_콤마로_끝남() {
        assertThatThrownBy(() -> runException("pope,ki,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAMES_LAST_COMMA);
    }

    @Test
    void 자동차_한개_등록() {
        assertThatThrownBy(() -> runException("pope", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_COUNT_IS_ONE);
    }

    @Test
    void 자동차_이름_중복() {
        assertThatThrownBy(() -> runException("pope,pope", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATE);
    }
}
