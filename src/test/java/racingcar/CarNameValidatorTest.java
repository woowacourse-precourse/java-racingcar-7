package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarNameValidatorTest {
    public final CarNameValidator validator = new CarNameValidator();


    @DisplayName("유효한 이름 테스트")
    @Test
    public void testValidCarName() {
        assertTrue(validator.validate("Car1")); // 유효한 이름
        assertTrue(validator.validate("ABCD")); // 유효한 이름
        assertTrue(validator.validate("12345")); // 유효한 이름
    }

    @DisplayName("길이가 6자 이상")
    @Test
    public void testInvalidCarNameTooLong() {
        assertFalse(validator.validate("CarName")); // 길이가 6자 이상
    }

    @DisplayName("빈 문자열")
    @Test
    public void testInvalidCarNameEmpty() {
        assertFalse(validator.validate("")); // 빈 문자열
    }

    @DisplayName("null")
    @Test
    public void testInvalidCarNameNull() {
        assertFalse(validator.validate(null)); // null
    }

    @DisplayName("공백만 있는 문자열")
    @Test
    public void testInvalidCarNameWhitespace() {
        assertFalse(validator.validate("    ")); // 공백만 있는 문자열
    }
}
