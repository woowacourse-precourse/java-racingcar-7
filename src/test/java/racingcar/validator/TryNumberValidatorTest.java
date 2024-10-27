package racingcar.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberValidatorTest {

    private final TryNumberValidator tryNumberValidator = new TryNumberValidator();

    @Test
    @DisplayName("시도 회수 입력 오류 검증")
    void testValidateTryNumber() {
        String tryNumber1 = "";
        String tryNumber2 = "sad";
        String tryNumber3 = " ";

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        tryNumberValidator.validateTryNumber(tryNumber1),
                "시도 횟수를 입력해주세요.");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        tryNumberValidator.validateTryNumber(tryNumber2),
                "잘못된 입력입니다. 숫자를 입력해주세요.");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        tryNumberValidator.validateTryNumber(tryNumber3),
                "잘못된 입력입니다. 숫자를 입력해주세요.");
    }
}