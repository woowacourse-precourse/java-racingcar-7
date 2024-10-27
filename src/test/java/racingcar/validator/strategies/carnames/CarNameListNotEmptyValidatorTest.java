package racingcar.validator.strategies.carnames;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.utils.CarNameParser;
import racingcar.view.ErrorMessage;

public class CarNameListNotEmptyValidatorTest {

    private final CarNameListNotEmptyValidator validator = new CarNameListNotEmptyValidator();

    @ParameterizedTest
    @CsvSource({
            "'Pobi, ,Woni', EMPTY_NAME_IN_LIST",  // 공백 이름 포함
            "'Pobi,,Woni', EMPTY_NAME_IN_LIST",   // 빈 문자열 포함
            "' , ', EMPTY_NAME_IN_LIST"           // 모두 공백 이름
    })
    void validate_WhenListContainsEmptyOrBlankName_ShouldThrowException(String carNames, String errorMessage) {
        List<String> carNameList = CarNameParser.splitCarNames(carNames);
        assertExceptionThrown(carNameList, errorMessage);
    }

    @ParameterizedTest
    @CsvSource({
            "'Pobi,Woni,Jun'",  // 모두 유효한 이름
            "'Alice,Bob,Carol'" // 모두 유효한 이름
    })
    void validate_WhenListContainsOnlyValidNames_ShouldNotThrowException(String carNames) {
        List<String> carNameList = CarNameParser.splitCarNames(carNames);
        assertNoExceptionThrown(carNameList);
    }

    private void assertExceptionThrown(List<String> carNames, String errorMessage) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.validate(carNames))
                .withMessage(ErrorMessage.valueOf(errorMessage).getMessage());
    }

    private void assertNoExceptionThrown(List<String> carNames) {
        assertThatNoException().isThrownBy(() -> validator.validate(carNames));
    }

}
