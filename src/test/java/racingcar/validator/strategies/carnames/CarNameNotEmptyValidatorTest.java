package racingcar.validator.strategies.carnames;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.view.ErrorMessage;

public class CarNameNotEmptyValidatorTest {

    private final CarNameNotEmptyValidator validator = new CarNameNotEmptyValidator();

    @ParameterizedTest
    @CsvSource({
            "'', EMPTY_CAR_NAMES",       // 빈 문자열
            "'   ', EMPTY_CAR_NAMES"     // 공백 문자열
    })
    void validate_WhenCarNamesEmptyOrBlank_ShouldThrowException(String carNames, String errorMessage) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(carNames))
                .withMessage(ErrorMessage.valueOf(errorMessage).getMessage());
    }

    @Test
    void validate_WhenCarNamesIsNull_ShouldThrowException() {
        // null은 CsvSource로 직접 전달할 수 없기 때문에 별도의 테스트 메서드에서 검증
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(null))
                .withMessage(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "'pobi,woni,jun'",  // 정상 입력
            "'alice,bob,carol'" // 정상 입력
    })
    void validate_WhenCarNamesValid_ShouldNotThrowException(String carNames) {
        assertThatNoException().isThrownBy(() -> validator.validate(carNames));
    }


}
