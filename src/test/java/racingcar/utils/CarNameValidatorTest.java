package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameValidatorTest {
    private InputValidator carNameValidator;

    @BeforeEach
    public void setUp() {
        carNameValidator = new CarNameValidator();
    }

    // 유효한 자동차 이름 입력 테스트
    @Test
    public void testValidCarNames() {
        String validCarNames = "pobi,woni,jun";
        assertDoesNotThrow(() -> carNameValidator.validate(validCarNames));
    }

    // 너무 긴 자동차 이름이 포함된 경우의 테스트
    @Test
    public void testInvalidCarNames_TooLongName() {
        String invalidCarNames = "pobi,woni,verylongname";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(invalidCarNames));
    }

    // 빈 이름이 포함된 경우의 자동차 이름 입력 테스트
    @Test
    public void testInvalidCarNames_EmptyName() {
        String invalidCarNames = "pobi,,jun";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(invalidCarNames));
    }

    // 중복된 자동차 이름이 포함된 경우의 테스트
    @Test
    public void testInvalidCarNames_DuplicateName() {
        String invalidCarNames = "pobi,woni,pobi";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(invalidCarNames));
    }
}
