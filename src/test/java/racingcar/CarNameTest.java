package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.ErrorMessage;
import racingcar.model.CarName;

public class CarNameTest {
    private static final String CAR_NAME_LENGTH_SIX = "soyeon";
    private static final String CAR_NAME_LENGTH_ZERO = "";
    private static final String CAR_NAME_HAS_BLANK_AT_FIRST = " asdf";
    private static final String CAR_NAME_HAS_BLANK_AT_MIDDLE = "s ye";
    private static final String CAR_NAME_HAS_BLANK_AT_LAST = "qwer ";

    @DisplayName("자동차 이름 길이가 1 이상 5 이하가 아닌 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {CAR_NAME_LENGTH_SIX, CAR_NAME_LENGTH_ZERO})
    public void ThrowExceptionIfCarNameLengthZeroOrMoreThanFive(String carName) {
        Throwable thrown = catchThrowable(() -> {
            CarName.validateLength(carName);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH_MIN_ONE_MAX_FIVE.getErrorMessage());
    }

    @DisplayName("자동차 이름에 공백이 포함되면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {CAR_NAME_HAS_BLANK_AT_FIRST, CAR_NAME_HAS_BLANK_AT_MIDDLE, CAR_NAME_HAS_BLANK_AT_LAST})
    public void ThrowExceptionIfCarNameHasBlank(String carName) {
        Throwable thrown = catchThrowable(() -> {
            CarName.validateHasBlank(carName);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_MUST_NOT_HAVE_BLANK.getErrorMessage());
    }
}
