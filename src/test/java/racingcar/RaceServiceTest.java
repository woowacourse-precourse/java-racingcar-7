package racingcar;

import static org.assertj.core.api.Assertions.*;
import static racingcar.race.constants.RaceCriterion.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.race.Race;

public class RaceServiceTest {

    private final RaceService raceService;

    @BeforeEach
    void setup() {
        raceService = new RaceService();
    }
    @Test
    void 우승자를_계산한다() {
        // given
        String input = "eric, jack";
        Race race = Race.of(input, new FixedAcceleration(MOVING_FORWARD.getCriterion()))
        race.lap();

        // when
        List<Car> winners = raceService.findWinners(race);

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("eric");
        assertThat(winners.get(1).getName()).isEqualTo("jack");
    }
}
