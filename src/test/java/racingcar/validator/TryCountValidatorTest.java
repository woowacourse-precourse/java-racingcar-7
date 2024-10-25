package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.view.ErrorMessage;

public class TryCountValidatorTest {

    private final TryCountValidator validator = new TryCountValidator();

    @ParameterizedTest
    @CsvSource({
            "'-3', INVALID_TRY_COUNT", // 음수 시도 횟수
            "'abc', INVALID_TRY_COUNT", // 숫자가 아닌 경우
            "'', EMPTY_TRY_COUNT", // 빈 문자열
            "'0', INVALID_TRY_COUNT" // 시도 횟수가 0인 경우
    })
    void validate_WhenInvalidTryCount_ShouldThrowException(String tryCount, String errorMessage) {
        // 유효하지 않은 시도 횟수일 경우 예외가 발생해야 함
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(tryCount))
                .withMessage(ErrorMessage.valueOf(errorMessage).getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "'1'",
            "'5'",
    })
    void validate_WhenTryCountIsPositive_ShouldNotThrowException(String tryCount) {
        // 유효한 시도 횟수인 경우 예외가 발생하지 않아야 함
        validator.validate(tryCount);
    }

}
