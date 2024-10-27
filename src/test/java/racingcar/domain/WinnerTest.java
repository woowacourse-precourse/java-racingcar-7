package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TrialCountsValidator;

public class WinnerTest {

    @Test
    void 한명의_우승자_테스트() {
        // given
        CarNameValidator carNameValidator = new CarNameValidator();
        Cars cars = new Cars("I'm,bo,wook,hi,^^", carNameValidator);

        // when
        int randomNumber = 0;
        for (Car car : cars.getCars()) {
            car.judgeMove(randomNumber++);
        }
        Winner winner = new Winner(cars);

        //then
        assertThat(winner.getWinners().size()).isEqualTo(1);
        assertThat(winner.getWinners().get(0).getCarName()).isEqualTo("^^");
    }

    @Test
    void 다수의_우승자_테스트() {
        // given
        CarNameValidator carNameValidator = new CarNameValidator();
        Cars cars = new Cars("bo,wook", carNameValidator);
        TrialCountsValidator trialCountsValidator = new TrialCountsValidator();
        TrialCounts trialCounts = new TrialCounts("5", trialCountsValidator);

        // when
        for (int i = 0; i < trialCounts.getTrialCounts(); i++) {
            cars.getCars().forEach(car -> car.judgeMove(4));
        }
        Winner winner = new Winner(cars);

        //then
        assertThat(winner.getWinners().size()).isEqualTo(2);
        assertThat(winner.getWinners().get(0).getCarName()).isEqualTo("bo");
        assertThat(winner.getWinners().get(1).getCarName()).isEqualTo("wook");
    }
}
