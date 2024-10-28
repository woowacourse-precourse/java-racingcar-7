package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.view.ErrorMessage;

public class CarNameValidatorTest {

    private final CarNameValidator validator = new CarNameValidator();

    @ParameterizedTest
    @CsvSource({
            "'Ferrari', NAME_TOO_LONG", // 5자 초과
            "'pobi,,woni', EMPTY_NAME_IN_LIST", // 빈 이름 포함
            "'pobi,woni,', TRAILING_COMMA", // 끝에 쉼표 포함
            "'pobi,woni,pobi', DUPLICATE_NAME", // 중복된 이름
            "'pobi', MINIMUM_CARS", // 1대 이하
            "'', EMPTY_CAR_NAMES" // 전체 빈 문자열
    })
    void validate_WhenInvalidCarNames_ShouldThrowException(String carNames, String errorMessage) {
        // 주어진 자동차 이름이 잘못된 경우 예외가 발생해야 함
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(carNames))
                .withMessage(ErrorMessage.valueOf(errorMessage).getMessage());
    }


    @ParameterizedTest
    @CsvSource({
            "'pobi,woni'", // 유효한 자동차 이름
            "'car1,car2,car3'" // 유효한 여러 이름
    })
    void validate_WhenCarNamesAreValid_ShouldNotThrowException(String carNames) {
        // 유효한 자동차 이름의 경우 예외가 발생하지 않아야 함
        validator.validate(carNames);
    }


}
