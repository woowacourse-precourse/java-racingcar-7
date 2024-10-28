package util.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {

    private Validator<String> carNameValidator;

    @BeforeEach
    void setUp() {
        carNameValidator = new CarNameValidatorImpl();
    }

    @Nested
    @DisplayName("유효하지 않은 입력 테스트")
    class InvalidInputTest {
        @ParameterizedTest
        @DisplayName("6글자 이상의 이름은 예외 처리한다.")
        @ValueSource(strings = {"pobi, asdfgh"})
        void carNameLengthTest(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> carNameValidator.validate(input))
                    .withMessage(Message.INVALID_NAME_LENGTH.getMessage());
        }

        @Test
        @DisplayName("이름이 공백일 경우 예외 처리한다.")
        void blankNameTest() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> carNameValidator.validate(""))
                    .withMessage(Message.EMPTY_OR_NULL_NAME.getMessage());
        }

        @Test
        @DisplayName("이름이 null일 경우 예외 처리한다.")
        void nullNameTest() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> carNameValidator.validate(null))
                    .withMessage(Message.EMPTY_OR_NULL_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 이름이 최소 두 개 이상 입력되지 않으면 예외 처리한다.")
        void singleCarNameTest() {
            String input = "pobi";
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> carNameValidator.validate(input))
                    .withMessage(Message.INVALID_SINGLE_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 이름이 쉼표로 구분되지 않으면 예외 처리한다.")
        void invalidDelimiterTest() {
            String input = "pobi&woni";
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> carNameValidator.validate(input))
                    .withMessage(Message.INVALID_DELIMITER.getMessage());
        }
    }

    @Nested
    @DisplayName("유효한 입력 테스트")
    class ValidInputTest {
        @ParameterizedTest
        @DisplayName("유효한 여러 이름 입력은 예외를 발생시키지 않는다.")
        @ValueSource(strings = {"pobi,woni,jun"})
        void validInputTest(String input) {
            assertThatCode(() -> carNameValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}
