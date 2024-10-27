package racingcar;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.validator.ValidateCarNames;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class InputCarNamesTest {
    private final ValidateCarNames validateCarNames = new ValidateCarNames();

    @DisplayName("시도 횟수가 빈 값이면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    public void ThrowExceptionIfRaceTimesEmpty(String carNames) {
        Throwable thrown = AssertionsForClassTypes.catchThrowable(() -> {
            validateCarNames.isBlank(carNames);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 빈 값이 될 수 없습니다.");
    }
}
