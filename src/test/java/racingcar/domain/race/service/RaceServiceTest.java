package racingcar.domain.race.service;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.race.constants.RaceCriterion.MOVING_FORWARD;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.acceleration.FixedAcceleration;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;
import racingcar.domain.race.vo.Round;
import racingcar.domain.race.vo.Winners;

public class RaceServiceTest {

    private RaceHelper raceService;

    @BeforeEach
    void setup() {
        raceService = new RaceHelper();
    }

    @Test
    void 우승자를_계산한다() {
        // given
        String input = "pobi,woni";
        Race race = Race.of(input, new FixedAcceleration(MOVING_FORWARD.getCriterion()));
        race.runRace(new Round(1));


        // when
        Winners winners = raceService.findWinners(race);

        // then
        assertThat(winners.winnerNames().size()).isEqualTo(2);
        assertThat(winners.winnerNames().get(0)).isEqualTo("pobi");
        assertThat(winners.winnerNames().get(1)).isEqualTo("woni");
    }
}
