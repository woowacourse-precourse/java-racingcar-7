package racingcar.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameRequestHandlerTest {

    private final NameRequestHandler nameRequestHandler = new NameRequestHandler();

    @DisplayName("빈 문자열 테스트")
    @Test
    public void blankInputValidateTest(){
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateBlank(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백 문자열 테스트")
    @Test
    public void EmptyInputValidateTest(){
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateBlank(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("null 테스트")
    @Test
    public void nullInputValidateTest(){
        Assertions.assertThatThrownBy(() -> nameRequestHandler.validateBlank(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
