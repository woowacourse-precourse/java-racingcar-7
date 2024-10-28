package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.View.ViewConstants.LESS_THAN_MIN_ROUNDS_ERROR_MESSAGE;
import static racingcar.model.RacingConstants.MIN_ROUNDS;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRacingServiceTest {

    @DisplayName("최소 시도 횟수보다 작은 값을 전달받으면 예외 발생")
    @Test
    void throwExceptionIfNumberIsLessThanMinRounds() {
        CarRacingService carRacingService = new CarRacingService();

        int number = MIN_ROUNDS - 1;

        assertThatThrownBy(() -> carRacingService.registerTotalRounds(number))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(LESS_THAN_MIN_ROUNDS_ERROR_MESSAGE);
    }

    @DisplayName("최소 시도 횟수보다 크거나 같은 값을 전달받으면 그 값을 반환")
    @ParameterizedTest
    @ValueSource(ints = {MIN_ROUNDS, MIN_ROUNDS + 1, 1, 2, 3, 10, 1000, Integer.MAX_VALUE})
    void returnTotalRoundsIfNumberIsAboveMinRounds(int number) {
        CarRacingService carRacingService = new CarRacingService();

        assertThat(carRacingService.registerTotalRounds(number)).isEqualTo(number);
    }
}