package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TrialCountsValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    void 최대_이동_거리_변경_테스트() {
        //given
        CarNameValidator carNameValidator = new CarNameValidator();
        TrialCountsValidator trialCountsValidator = new TrialCountsValidator();
        Cars cars = new Cars("bo,wook,hi", carNameValidator);
        TrialCounts trialCounts = new TrialCounts("5", trialCountsValidator);
        Race race = new Race(cars, trialCounts);

        //when
        for (int i = 0; i < trialCounts.getTrialCounts(); i ++) {
            race.raceOneStep();
        }
        assertThat(race.isRaceOngoing()).isFalse();

        //then
        int maxPosition = race.getMaxPosition();
        assertThat(maxPosition).isGreaterThanOrEqualTo(0);

    }

}
