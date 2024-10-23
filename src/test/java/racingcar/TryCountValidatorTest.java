package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.TryCountValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TryCountValidatorTest {
    private TryCountValidator tryCountValidator;

    @BeforeEach
    void setUp() {
        tryCountValidator = new TryCountValidator();
    }

    @DisplayName("시도 횟수에 int형으로 변환할 수 없는 문자열을 입력하면 예외가 발생한다.")
    @Test
    void stringTryCount() {
        //Arrange
        String input = "a";

        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            tryCountValidator.convertTryCountToInt(input);
        });
    }

    @DisplayName("시도 횟수에 음수를 입력하면 예외가 발생한다.")
    @Test
    void negativeTryCount() {
        //Arrange
        int input = -4;

        //Act
        assertThrows(IllegalArgumentException.class, () -> {
            tryCountValidator.validTryCount(input);
        });
    }
}
