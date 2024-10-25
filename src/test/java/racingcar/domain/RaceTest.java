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

        //when
        for (int i = 0; i < trialCounts.getTrialCounts(); i ++) {
            cars.getCars().forEach(car -> car.move(4));
        }
        Winner winner = new Winner(cars);
        int maxPosition = winner.getWinnerPosition();

        //then
        assertThat(maxPosition).isEqualTo(5);
    }

}
