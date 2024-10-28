package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.constant.MoveCarNumberConstant.EXECUTION_RANGE_MAX_VALUE;
import static racingcar.util.constant.MoveCarNumberConstant.EXECUTION_RANGE_MIN_VALUE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.EmptyInputException;
import racingcar.exception.executionNumber.NotNumberException;
import racingcar.exception.executionNumber.NumberRangeException;
import racingcar.model.ExecutionNumber;
import racingcar.util.DataTransformUtil;
import racingcar.util.ValidationUtil;

class RegisterExecutionNumberServiceTest {

    ValidationUtil validationUtil = new ValidationUtil();
    DataTransformUtil dataTransformUtil = new DataTransformUtil();
    RegisterExecutionNumberService registerExecutionNumberService = new RegisterExecutionNumberService(validationUtil,
            dataTransformUtil);

    @Nested
    @DisplayName("시도 횟수 등록 테스트")
    class registerExecutionNumberTests {

        @Test
        void 빈_입력값_예외테스트() {
            String input = "";
            assertThrows(
                    EmptyInputException.class,
                    () -> registerExecutionNumberService.registerExecutionNumber(input)
            );
        }

        @Test
        void 숫자가_아닌_문자_예외테스트() {
            String input = "?";
            assertThrows(
                    NotNumberException.class,
                    () -> registerExecutionNumberService.registerExecutionNumber(input)
            );
        }

        @Test
        void 숫자_최소범위_예외테스트() {
            String input = String.valueOf(EXECUTION_RANGE_MIN_VALUE.getValue() - 1);
            assertThrows(
                    NumberRangeException.class,
                    () -> registerExecutionNumberService.registerExecutionNumber(input)
            );
        }

        @Test
        void 숫자_최소범위_테스트() {
            String input = String.valueOf(EXECUTION_RANGE_MIN_VALUE.getValue());
            assertEquals(
                    registerExecutionNumberService.registerExecutionNumber(input),
                    new ExecutionNumber(EXECUTION_RANGE_MIN_VALUE.getValue())
            );
        }

        @Test
        void 숫자_최대범위_예외테스트() {
            String input = String.valueOf(EXECUTION_RANGE_MAX_VALUE.getValue() + 1);
            assertThrows(
                    NumberRangeException.class,
                    () -> registerExecutionNumberService.registerExecutionNumber(input)
            );
        }

        @Test
        void 숫자_최대범위_테스트() {
            String input = String.valueOf(EXECUTION_RANGE_MAX_VALUE.getValue());
            assertEquals(
                    registerExecutionNumberService.registerExecutionNumber(input),
                    new ExecutionNumber(EXECUTION_RANGE_MAX_VALUE.getValue())
            );
        }
    }
}