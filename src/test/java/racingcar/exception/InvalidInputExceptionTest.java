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
        @DisplayName("초기 입력이 공백일 때")
        void testValidateInput_BlankInput_ShouldThrowException() {
            assertThatThrownBy(() -> validateInput(" "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }

        @Test
        @DisplayName("초기 입력이 null일 때")
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
        @DisplayName("자동차 이름을 하나만 입력 했을 때")
        void testValidateCarNames_SingleCarName_ShouldThrowException() {
            assertThatThrownBy(() -> validateCarNames(new String[]{"test"}))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_AT_LEAST_TWO_CAR.getMessage());
        }

        @Test
        @DisplayName("자동차 이름에 공백이 있을 때")
        void testValidateCarNameBlankInput_BlankInput_ShouldThrowException() {
            assertThatThrownBy(() -> validateCarNames(new String[]{"test", ""}))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }

        @Test
        @DisplayName("자동차 이름에 null이 있을 때")
        void testValidateCarNameBlankInput_NullIInput_ShouldThrowException() {
            assertThatThrownBy(() -> validateCarNames(new String[]{"test", null}))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }

        @Test
        @DisplayName("자동차 이름에 중복이 있을 때")
        void testValidateDuplicateName_DuplicateInput_ShouldThrowException() {
            assertThatThrownBy(() -> validateCarNames(new String[]{"test", "test"}))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.DUPLICATE_INPUT.getMessage());
        }

        @Test
        @DisplayName("자동차 이름이 5글자를 초과했을 때")
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
        @DisplayName("0 입력했을 때")
        void testValidateAttemptCount_ZeroAttempt_ShouldThrowException() {
            assertThatThrownBy(() -> validateAttemptCount(0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_ONLY_POSITIVE_INTEGER.getMessage());
        }

        @Test
        @DisplayName("음수 입력했을 때")
        void testValidateAttemptCount_NegativeAttempt_ShouldThrowException() {
            assertThatThrownBy(() -> validateAttemptCount(-1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INPUT_ONLY_POSITIVE_INTEGER.getMessage());
        }

        @Test
        @DisplayName("3 입력했을 때")
        void testValidateAttemptCount_ValidAttempt_ShouldNotThrowException() {
            validateAttemptCount(3);
        }
    }
}