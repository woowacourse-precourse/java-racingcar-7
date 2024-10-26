package racingcar.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.message.ErrorMessage.*;

public class NameRequestHandlerTest {

    private final NameRequestHandler nameRequestHandler = new NameRequestHandler();

    @DisplayName("빈 문자열 검증")
    @Test
    public void blankInputValidateTest() {
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateBlank(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK_INPUT_ERROR.getMessage());
    }

    @DisplayName("공백 문자열 검증")
    @Test
    public void EmptyInputValidateTest() {
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateBlank(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK_INPUT_ERROR.getMessage());
    }

    @DisplayName("null 검증")
    @Test
    public void nullInputValidateTest() {
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateBlank(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK_INPUT_ERROR.getMessage());
    }

    @DisplayName("띄어쓰기 포함 문자열 검증")
    @Test
    public void containsSpaceValidateTest() {
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateSpace("as d,ds"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTAINS_SPACE_ERROR.getMessage());
    }

    @DisplayName("이름이 1글자 이상, 5글자 이하인 경우")
    @Test
    public void namesLengthValidateTest() {
        Assertions.assertThatCode(() -> nameRequestHandler.validateNames(new String[]{"영선", "이영선차", "자동차"}))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름이 빈 문자열인 경우")
    @Test
    public void nameBlankValidateTest() {
        Assertions.assertThatCode(() -> nameRequestHandler.validateNames(new String[]{"영선", "", "자동차"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LENGTH_ERROR.getMessage());
    }

    @DisplayName("이름이 6글자 이상인 경우")
    @Test
    public void validateNamesWithExcessiveLength() {
        Assertions.assertThatCode(() -> nameRequestHandler.validateNames(new String[]{"영선", "이영선차123", "자동차"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LENGTH_ERROR.getMessage());
    }

}
