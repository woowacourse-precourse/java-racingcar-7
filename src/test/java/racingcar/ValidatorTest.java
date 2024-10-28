package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Validator Tests")
public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validator.getInstance();
    }

    @Nested
    @DisplayName("시도횟수 검증")
    class TryCountValidation {

        @Test
        @DisplayName("공백 입력 시 예외 발생")
        void throwsExceptionWhenTryCountIsEmpty() {
            String input = "";
            assertThatThrownBy(() -> validator.validateTryCounts(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도할 횟수를 입력해야합니다.");
        }

        @Test
        @DisplayName("양의 정수 외 입력 시 예외 발생")
        void throwsExceptionWhenTryCountIsZeroOrNegative() {
            String input = "0";
            assertThatThrownBy(() -> validator.validateTryCounts(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("양의 정수만 입력 가능합니다.");
        }

        @Test
        @DisplayName("정수가 아닌 값 입력 시 예외 발생")
        void throwsExceptionWhenTryCountIsNotInteger() {
            String input = "A";
            assertThatThrownBy(() -> validator.validateTryCounts(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도횟수는 정수이어야 합니다.");
        }

        @Test
        @DisplayName("정상 입력에 대한 예외가 반환되지 않는 케이스 검증")
        void doesNotThrowExceptionWhenTryCountIsPositiveInteger() {
            String input = "5";
            validator.validateTryCounts(input);
        }
    }
}