package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.FixedMovementStrategy;

class CarRaceTest {

    @ParameterizedTest
    @DisplayName("시도 횟수가 범위 안에 있다면 CarRace 객체를 생성할 수 있다.")
    @ValueSource(ints = 1)
    void canCreateCarRaceWhenAttemptCountIsValid(int attemptCount) {
        // given
        CarRace carRace = new CarRace(attemptCount);

        // when
        List<String> exceptedFinalWinner = List.of();

        // then
        assertThat(carRace.getFinalWinners()).isEqualTo(exceptedFinalWinner);
    }
    @ParameterizedTest
    @DisplayName("시도 횟수가 범위 안에 있다면 CarRace 객체를 생성할 수 있다.")
    @ValueSource(ints = {0, 101})
    void canNotCreateCarRaceWhenAttemptCountIsNotValid(int attemptCount) {
        // when && then
        assertThatThrownBy(() -> new CarRace(attemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는");
    }

    @ParameterizedTest
    @DisplayName("시도 횟수가 범위 안에 있다면 CarRace 객체를 생성할 수 있다.")
    @ValueSource(ints = 1)
    void carRaceTest(int attemptCount) {
        // given
        String[] carNames = {"pobi", "woni", "jun"};
        FixedMovementStrategy fixedMovementStrategy = new FixedMovementStrategy(4);
        Cars cars = new Cars(carNames, fixedMovementStrategy);
        CarRace carRace = new CarRace(attemptCount);

        // when
        carRace.startRace(cars);
        List<String> exceptedFinalWinner = List.of("pobi", "woni", "jun");

        // then
        assertThat(carRace.getFinalWinners()).isEqualTo(exceptedFinalWinner);
    }
}