package racingcar.validator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;

public class ValidatorTest{
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    @DisplayName("자동차 이름 검증 - 정상")
    void validateCarNameTest_validName() {
        // 정상적인 이름으로 검증 시 예외가 발생하지 않아야 함
        validator.validateCarName("car1");
    }

    @Test
    @DisplayName("자동차 이름 검증 - 빈 문자열")
    void validateCarNameTest_emptyName() {
        // 빈 문자열이 입력될 경우 INVALID_CAR_NAME 예외 메시지가 발생해야 함
        IllegalArgumentException exception = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> validator.validateCarName(""),
                "예외가 발생해야 합니다."
        );
        assertEquals(ErrorCode.INVALID_CAR_NAME.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 검증 - 이름 길이 초과")
    void validateCarNameTest_nameTooLong() {
        // 이름이 5자를 초과할 경우 INVALID_CAR_NAME 예외 메시지가 발생해야 함
        IllegalArgumentException exception = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> validator.validateCarName("toolongname"),
                "예외가 발생해야 합니다."
        );
        assertEquals(ErrorCode.INVALID_CAR_NAME.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 검증 - 숫자 아님")
    void validateTryCountTest_invalidNumberFormat() {
        // 숫자가 아닌 입력 시 TRY_COUNT_IS_NOT_NUMBER 예외 메시지가 발생해야 함
        IllegalArgumentException exception = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> validator.validateTryCount("abc"),
                "예외가 발생해야 합니다."
        );
        assertEquals(ErrorCode.TRY_COUNT_IS_NOT_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 검증 - 1 미만")
    void validateTryCountTest_lessThanOne() {
        // 시도 횟수가 1 미만일 경우 INVALID_TRY_COUNT 예외 메시지가 발생해야 함
        IllegalArgumentException exception = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> validator.validateTryCount("0"),
                "예외가 발생해야 합니다."
        );
        assertEquals(ErrorCode.INVALID_TRY_COUNT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 검증 - 유효한 시도 횟수")
    void validateTryCountTest_validAttempt() {
        // 유효한 시도 횟수가 입력되었을 경우 반환된 시도 횟수가 정확한지 확인
        int attempts = validator.validateTryCount("3");
        assertEquals(3, attempts);
    }

}
