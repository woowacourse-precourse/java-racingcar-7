package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.message.Message;

class CountValidationTest {

    private CountValidation countValidation;

    @BeforeEach
    void setup() {
        countValidation = new CountValidation();
    }

    @Test
    void 예외발생_음수_테스트() {
        String input = "-1";

        assertThatThrownBy(() -> countValidation.convertToNaturalNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.naturalNumber.getMessage());
    }

    @Test
    void 예외발생_0_테스트() {
        String input = "0";

        assertThatThrownBy(() -> countValidation.convertToNaturalNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.naturalNumber.getMessage());
    }

    @Test
    void 예외발생_문자열_테스트() {
        String input = "abc";

        assertThatThrownBy(() -> countValidation.convertToNaturalNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.naturalNumber.getMessage());
    }

    @Test
    void 정상작동_자연수_테스트() {
        // Arrange
        String input = "5";

        // Act
        int result = countValidation.convertToNaturalNum(input);

        // Assert
        assertEquals(5, result);
    }
}