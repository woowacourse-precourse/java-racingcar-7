package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.rule.RaceRule;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    private final RaceRule alwaysMoveRule = () -> true;

    @Test
    @DisplayName("라운드마다 자동차에 전진을 지시할 수 있다")
    void playRound_MovesCarsForward() {
        // Given
        List<Car> cars = List.of(new Car("nana"), new Car("ppo"));
        Race race = new Race(cars, 5, alwaysMoveRule);

        // When
        race.playRound();

        // Then
        assertThat(cars.get(0).getDistance()).isEqualTo(1);
        assertThat(cars.get(1).getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 라운드 횟수만큼 경주를 진행한다")
    void raceEndsAfterGivenRounds() {
        // Given
        List<Car> cars = List.of(new Car("nana"), new Car("ppo"));
        Race race = new Race(cars, 3, alwaysMoveRule);

        // When
        for (int i = 0; i < 3; i++) {
            race.playRound();
        }

        // Then
        assertThat(race.isRaceOver()).isTrue();
    }

    @Test
    @DisplayName("공동 우승한 경우 최종 우승한 자동차 이름 리스트를 생성한다")
    void createWinnerNameList_ReturnsWinners() {
        // Given
        List<Car> cars = List.of(new Car("nana"), new Car("ppo"));
        Race race = new Race(cars, 3, alwaysMoveRule);

        // When
        for (int i = 0; i < 3; i++) {
            race.playRound();
        }
        List<String> winners = race.createWinnerNameList();

        // Then
        assertThat(winners).containsExactlyInAnyOrder("nana", "ppo");
    }
}
