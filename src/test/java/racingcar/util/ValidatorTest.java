package racingcar.util;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("유효한 자동차 이름 목록")
    public void testValidCarNames() {
        List<String> result = Validator.validateCarNames("Tom, Jerry, Spike");
        assertEquals(List.of("Tom", "Jerry", "Spike"), result);
    }

    @Test
    @DisplayName("자동차 이름 길이가 제한 초과인 경우 예외 발생")
    public void testCarNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames("Tom, Jerryyyyy, Spike");
        });
    }

    @Test
    @DisplayName("자동차 이름에 특수 문자가 포함된 경우 예외 발생")
    public void testCarNameWithSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames("Tom, Jerry@, Spike");
        });
    }

    @Test
    @DisplayName("자동차 이름이 숫자로 시작하는 경우 예외 발생")
    public void testCarNameStartsWithNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames("1Tom, Jerry, Spike");
        });
    }

    @Test
    @DisplayName("자동차 이름에 중간 공백이 포함된 경우 예외 발생")
    public void testCarNameWithSpace() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames("Tom, Jerry Kim, Spike");
        });
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있는 경우 예외 발생")
    public void testDuplicateCarNames() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames("Tom, Jerry, Tom");
        });
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열 또는 null인 경우 예외 발생")
    public void testEmptyOrNullCarNames() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames(null);
        });
    }

    @Test
    @DisplayName("유효한 라운드 수 입력")
    public void testValidRoundCount() {
        int result = Validator.validateRoundCount("5");
        assertEquals(5, result);
    }

    @Test
    @DisplayName("라운드 수가 음수인 경우 예외 발생")
    public void testNegativeRoundCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateRoundCount("-3");
        });
    }

    @Test
    @DisplayName("라운드 수가 실수인 경우 예외 발생")
    public void testRoundCountAsDecimal() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateRoundCount("3.5");
        });
    }

    @Test
    @DisplayName("라운드 수가 빈 문자열 또는 null인 경우 예외 발생")
    public void testEmptyOrNullRoundCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateRoundCount("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateRoundCount(null);
        });
    }

    @Test
    @DisplayName("라운드 수가 문자로 입력된 경우 예외 발생")
    public void testRoundCountAsText() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateRoundCount("two");
        });
    }
}

