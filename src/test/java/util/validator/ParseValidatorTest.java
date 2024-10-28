package util.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParseValidatorTest {
    private ParseValidator parseValidator;

    @BeforeEach
    void setUp() {
        parseValidator = new ParseIntValidator();
    }

    @Nested
    @DisplayName("유효하지 않은 입력 테스트")
    class InvalidInputTest {
        @ParameterizedTest
        @DisplayName("유효하지 않은 입력입니다.")
        @ValueSource(strings = {"a"})
        void carNameLengthTest(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> parseValidator.validateParseInt(input))
                    .withMessage(Message.INVALID_PARSE_INT.getMessage());
        }
    }

    @Nested
    @DisplayName("유효한 입력 테스트")
    class ValidInputTest {
        @ParameterizedTest
        @DisplayName("유효한 입력입니다.")
        @ValueSource(strings = {"5"})
        void carNameLengthTest(String input) {
            assertThatCode(() -> parseValidator.validateParseInt(input))
                    .doesNotThrowAnyException();
        }
    }
}
