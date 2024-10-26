package racingcar.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.message.ErrorMessage.BLANK_INPUT_ERROR;
import static racingcar.message.ErrorMessage.CONTAINS_SPACE_ERROR;

public class NameRequestHandlerTest {

    private final NameRequestHandler nameRequestHandler = new NameRequestHandler();

    @DisplayName("빈 문자열 검증")
    @Test
    public void blankInputValidateTest(){
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateBlank(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK_INPUT_ERROR.getMessage());
    }

    @DisplayName("공백 문자열 검증")
    @Test
    public void EmptyInputValidateTest(){
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateBlank(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK_INPUT_ERROR.getMessage());
    }

    @DisplayName("null 검증")
    @Test
    public void nullInputValidateTest(){
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateBlank(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK_INPUT_ERROR.getMessage());
    }

    @DisplayName("띄어쓰기 포함 문자열 검증")
    @Test
    public void containsSpaceValidateTest(){
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateSpace("as d,ds"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTAINS_SPACE_ERROR.getMessage());
    }
}
