package racingcar;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.race.constants.RaceCriterion.MOVING_FORWARD;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;
import racingcar.domain.race.service.RaceHelper;

public class RaceServiceTest {

    private RaceHelper raceService;

    @BeforeEach
    void setup() {
        raceService = new RaceHelper();
    }

    @Test
    void 우승자를_계산한다() {
        // given
        String input = "eric,jack";
        Race race = Race.of(input, new FixedAcceleration(MOVING_FORWARD.getCriterion()));
        race.lap();

        // when
        List<Car> winners = raceService.determineWinners(race);

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("eric");
        assertThat(winners.get(1).getName()).isEqualTo("jack");
    }
}
