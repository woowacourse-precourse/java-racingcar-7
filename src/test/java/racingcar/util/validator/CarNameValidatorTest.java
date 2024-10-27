package racingcar.util.validator;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ExceptionMessage;

class CarNameValidatorTest {

    private CarNameValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CarNameValidator();
    }

    @Nested
    class invalidInputTest {

        @DisplayName("2개 미만의 이름은 예외 처리")
        @ParameterizedTest
        @ValueSource(strings = {"버피", "우텍호"})
        void 이름_개수_테스트(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NUMBER_OF_CARS.getMessage());
        }
        @DisplayName("6글자 이상의 이름은 예외 처리")
        @ParameterizedTest
        @ValueSource(strings = {"가나다라마바사,       뿌우 ", "기차칙칙폭폭,버피아주아주사랑해"})
        void 이름_길이_테스트(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"버피,버핑,우테코"})
        void 정상_입력(String input) {
            assertThatCode(() -> validator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}