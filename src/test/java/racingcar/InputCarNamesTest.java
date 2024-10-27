package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.model.CarScores;

public class InputCarNamesTest {
    @DisplayName("시도 횟수가 빈 값이면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    public void ThrowExceptionIfRaceTimesEmpty(String carNames) {
        Throwable thrown = AssertionsForClassTypes.catchThrowable(() -> {
             CarScores.isBlank(carNames);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값이 될 수 없습니다.");
    }
}
