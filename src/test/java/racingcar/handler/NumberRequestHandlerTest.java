package racingcar.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.message.ErrorMessage.*;

public class NumberRequestHandlerTest {

    private final NumberRequestHandler numberRequestHandler = new NumberRequestHandler();

    @DisplayName("정상적인 값을 받아서 처리하는 경우")
    @Test
    public void validNumberTest() {
        // given
        String inputString = "12312";

        // when
        int result = numberRequestHandler.convertToInteger(inputString);
        int expectedResult = 12312;

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("정수가 아닌 문자열을 받아서 처리하는 경우")
    @Test
    public void invalidNumberTest() {
        // given
        String inputString = "123d12";

        // when, then
        Assertions.assertThatThrownBy(() -> numberRequestHandler.convertToInteger(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_ERROR.getMessage());
    }

    @DisplayName("빈 문자열을 받아서 처리하는 경우")
    @Test
    public void blankNumberTest() {
        // given
        String inputString = "";

        // when, then
        Assertions.assertThatThrownBy(() -> numberRequestHandler.convertToInteger(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_ERROR.getMessage());
    }

    @DisplayName("음수 검증")
    @Test
    public void negativeNumberTest() {
        // given
        int inputString = -1236465908;

        // when, then
        Assertions.assertThatThrownBy(() -> numberRequestHandler.validateNegative(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_NUMBER_ERROR.getMessage());
    }

}
