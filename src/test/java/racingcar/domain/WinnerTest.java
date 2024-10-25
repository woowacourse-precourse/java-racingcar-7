package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TrialCountsValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @Test
    void 다수의_우승자_테스트() {
        // given
        CarNameValidator carNameValidator = new CarNameValidator();
        Cars cars = new Cars("bo,wook", carNameValidator);
        TrialCountsValidator trialCountsValidator = new TrialCountsValidator();
        TrialCounts trialCounts = new TrialCounts("5", trialCountsValidator);

        // when
        for (int i = 0; i < trialCounts.getTrialCounts(); i++) {
            cars.getCars().forEach(car -> car.move(4));
        }
        Winner winner = new Winner(cars);

        //then
        assertThat(winner.getWinners().size()).isEqualTo(2);
    }
}
