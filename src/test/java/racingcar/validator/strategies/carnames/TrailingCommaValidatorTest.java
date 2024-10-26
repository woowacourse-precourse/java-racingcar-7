package racingcar.validator.strategies.carnames;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.view.ErrorMessage;

public class TrailingCommaValidatorTest {

    private final TrailingCommaValidator validator = new TrailingCommaValidator();

    @ParameterizedTest
    @CsvSource({
            "'Pobi,Woni,Jun,'",   // 쉼표로 끝나는 경우
            "'Alice,Bob,Carol,'", // 쉼표로 끝나는 경우
    })
    void validate_WhenCarNamesEndsWithComma_ShouldThrowException(String carNames) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(carNames))
                .withMessage(ErrorMessage.TRAILING_COMMA.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "'Pobi,Woni,Jun'",  // 정상적인 끝
            "'Alice,Bob,Carol'" // 정상적인 끝
    })
    void validate_WhenCarNamesDoesNotEndWithComma_ShouldNotThrowException(String carNames) {
        assertThatNoException().isThrownBy(() -> validator.validate(carNames));
    }

}
