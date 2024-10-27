package racingcar.util.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ExceptionMessage;

public class  TrialsCountValidatorTest {

    private TrialsCountValidator validator;

    @BeforeEach
    void setUp() {
        validator = new TrialsCountValidator();
    }

    @Nested
    class invalidInputTest {

        @DisplayName("자연수가 아닌 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"한글", "eng", "우테코    블랭크     ", " -1000 ", "-1   3   5"})
        void 자연수가_아닌_입력(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NOT_NATURAL_NUMBER.getMessage());
        }

        @DisplayName("(시도 회수를 1~1000 범위에 초과한 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1001", "1234566789"})
        void 시도_입력_범위를_벗어난_입력(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_OUT_OF_INPUT_BOUND.getMessage());
        }
    }

    @Nested
    class validInputTest {

        @ParameterizedTest
        @ValueSource(strings = {"5", "100", "   9   9  "})
        void 정상_입력(String input) {
            assertThatCode(() -> validator.validate(input))
                    .doesNotThrowAnyException();
        }

    }
}