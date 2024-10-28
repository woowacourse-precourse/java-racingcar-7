package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessage.BLANK_INPUT_ERROR;
import static racingcar.message.ErrorMessage.CONTAINS_SPACE_ERROR;

public class ApplicationFailTest extends NsTest {

    @DisplayName("이름은 6글자 이상이면 예외가 발생한다.")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("입력 문자열이 빈 문자열이면 예외를 발생시킨다")
    @Test
    void blankInputException() {
        assertThatThrownBy(() -> runException("\n"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK_INPUT_ERROR.getMessage());
    }

    @DisplayName("입력 문자열이 공백 문자열이면 예외를 발생시킨다")
    @Test
    void emptyInputException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(BLANK_INPUT_ERROR.getMessage())
        );
    }

    @DisplayName("입력 문자열이 띄어쓰기를 포함하는 경우 예외를 발생시킨다")
    @Test
    void inputContainsSpaceException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java, 1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(CONTAINS_SPACE_ERROR.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
