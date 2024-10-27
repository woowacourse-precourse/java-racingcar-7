package racingcar.exception;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.InvalidInputException.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("예외 처리 테스트")
class InvalidInputExceptionTest {

    @Nested
    @DisplayName("자동차 이름 입력 예외 테스트")
    class carNameInput {

        @Test
        @DisplayName("자동차 이름 정상 입력 시 예외 발생하지 않음")
        void testValidateCarNames() {
            validateCarNames(new String[]{"test1", "test2", "test3"});
        }

        @Test
        @DisplayName("공백 입력 시 예외 발생")
        void testValidateInput_BlankInput_ShouldThrowException() {
            assertThatThrownBy(() -> validateInput(" "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }

        @Test
        @DisplayName("null 입력 시 예외 발생")
        void testValidateInput_NullInput_ShouldThrowException() {
            assertThatThrownBy(() -> validateInput(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }
    }

    @Nested
    @DisplayName("자동차 이름 파싱 후 예외 테스트")
    class afterParsingInput {
        @Test
        @DisplayName("자동차 이름이 하나일 때 예외 발생")
        void testValidateCarNames_SingleCarName_ShouldThrowException() {
            assertThatThrownBy(() -> validateCarNames(new String[]{"test"}))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_AT_LEAST_TWO_CAR.getMessage());
        }

        @Test
        @DisplayName("자동차 이름에 공백 포함 시 예외 발생")
        void testValidateCarNameBlankInput_BlankInput_ShouldThrowException() {
            assertThatThrownBy(() -> validateCarNames(new String[]{"test", ""}))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }

        @Test
        @DisplayName("자동차 이름에 null 포함 시 예외 발생")
        void testValidateCarNameBlankInput_NullIInput_ShouldThrowException() {
            assertThatThrownBy(() -> validateCarNames(new String[]{"test", null}))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }

        @Test
        @DisplayName("자동차 이름 중복 시 예외 발생")
        void testValidateDuplicateName_DuplicateInput_ShouldThrowException() {
            assertThatThrownBy(() -> validateCarNames(new String[]{"test", "test"}))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.DUPLICATE_INPUT.getMessage());
        }

        @Test
        @DisplayName("자동차 이름이 5글자 초과 시 예외 발생")
        void testValidateCarNames_ExceedMaxCarNameLength_ShouldThrowException() {
            assertThatThrownBy(() -> validateCarNames(new String[]{"test", "testString"}))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.EXCEED_MAX_INPUT_LENGTH.getMessage());
        }
    }

    @Nested
    @DisplayName("시도 횟수 입력 예외 테스트")
    class attemptCountInput {
        @Test
        @DisplayName("0 입력 시 예외 발생")
        void testValidateAttemptCount_ZeroAttempt_ShouldThrowException() {
            assertThatThrownBy(() -> validateAttemptCount(0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_ONLY_POSITIVE_INTEGER.getMessage());
        }

        @Test
        @DisplayName("음수 입력 시 예외 발생")
        void testValidateAttemptCount_NegativeAttempt_ShouldThrowException() {
            assertThatThrownBy(() -> validateAttemptCount(-1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_ONLY_POSITIVE_INTEGER.getMessage());
        }

        @Test
        @DisplayName("양수 입력 시 예외 발생하지 않음")
        void testValidateAttemptCount_ValidAttempt_ShouldNotThrowException() {
            validateAttemptCount(3);
        }
    }
}