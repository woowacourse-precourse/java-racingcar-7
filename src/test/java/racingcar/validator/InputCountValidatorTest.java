package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputCountValidatorTest {
    private InputCountValidator inputCountValidator;

    @BeforeEach
    void setUp() {
        inputCountValidator = new InputCountValidator();
    }

    @Test
    void Given_이동_횟수_When_isAboveMinimumTryCount_호출시_Expect_예외를_발생시킨다() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputCountValidator.isAboveMinimumTryCount(0);
        });
        assertEquals("0 이하의 숫자입니다.", exception.getMessage());
    }

    @Test
    void Given_이동_횟수_When_isPossibleConvertNumber_호출시_Expect_예외를_발생시킨다() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputCountValidator.isPossibleConvertNumber("a");
        });
        assertEquals("숫자가 아닌 값이 입력되었습니다.", exception.getMessage());
    }

    @Test
    void Given_이동_횟수_When_isValidScope_호출시_Expect_예외를_발생시킨다() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputCountValidator.isValidScope("2147483648");
        });
        assertEquals("int 자료형의 범위를 넘어서는 입력값입니다.", exception.getMessage());
    }

    @Test
    void Given_이동_횟수_When_isNotBlankTryCount_호출시_Expect_예외를_발생시킨다() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputCountValidator.isNotBlankTryCount("");
        });
        assertEquals("공백이 입력되었습니다.", exception.getMessage());
    }
}
