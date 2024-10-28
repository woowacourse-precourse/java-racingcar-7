package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.model.CarScores;
import racingcar.constants.ErrorMessage;

public class InputCarNamesTest {
    @DisplayName("자동차 이름이 빈 값이면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    public void ThrowExceptionIfRaceTimesEmpty(String carNames) {
        Throwable thrown = AssertionsForClassTypes.catchThrowable(() -> {
             CarScores.isBlank(carNames);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_CAN_NOT_BE_EMPTY.getErrorMessage());
    }
}
