package racingcar.domain.race;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.result.RaceResult;

class RaceTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(
                new Car("Car1", () -> true),  // 항상 전진하는 전략
                new Car("Car2", () -> true),
                new Car("Car3", () -> false)  // 항상 전진하지 않는 전략
        );
    }

    @DisplayName("한 라운드가 실행되면 각 자동차가 이동한다.")
    @Test
    void runOneRound() {
        // given
        int totalRounds = 3;
        Race race = new Race(cars, totalRounds);

        // when
        race.runOneRound();

        // then
        assertThat(race.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(race.getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(race.getCars().get(2).getPosition()).isEqualTo(0);
    }

    @DisplayName("전체 경주가 끝나면 최종 우승자가 결정된다.")
    @Test
    void raceStart_decidesWinner() {
        // given
        int totalRounds = 3;
        Race race = new Race(cars, totalRounds);

        // when
        RaceResult result = race.raceStart();

        // then
        //항상 전진하는 Car1과 Car2 공동 우승
        assertThat(result.getWinners()).containsExactlyInAnyOrder(cars.get(0), cars.get(1));
    }

    @DisplayName("모든 라운드를 실행하면, 각 라운드에서 자동차의 위치가 변화한다.")
    @Test
    void raceStart_carsMoveInRounds() {
        // given
        Race race = new Race(cars, 3);

        // when
        race.raceStart();

        // then
        assertThat(race.getCars().get(0).getPosition()).isEqualTo(3);
        assertThat(race.getCars().get(1).getPosition()).isEqualTo(3);
        assertThat(race.getCars().get(2).getPosition()).isEqualTo(0);
    }

}