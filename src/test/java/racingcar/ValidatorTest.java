package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @DisplayName("입력된 문자열이 빈칸인 경우 IllegalArgumentException 예외 발생")
    @Test
    void validateInputNotBlank_ShouldThrowException_WhenInputIsBlank() {
        String blankInput = "   ";
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateInputNotBlank(blankInput));
    }
}
