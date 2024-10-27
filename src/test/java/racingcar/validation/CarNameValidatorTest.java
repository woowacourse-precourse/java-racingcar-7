package racingcar.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.ErrorMessageConstants;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi, woni,jun ", "po bi,woni,jun"})
    void 자동차_이름_공백_포함_예외_테스트(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.ERROR_CAR_NAME_CONTAINS_BLANK);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름_null_또는_빈_문자열_예외_테스트(String carName) {
        List<String> carNames = Arrays.asList(carName, "woni", "jun");
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstants.ERROR_EMPTY_CAR_NAME);
    }
}
