package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.validator.CarNameValidator;

public class RaceTest {

    @Test
    void 최대_이동_거리_변경_테스트() {
        //given
        CarNameValidator carNameValidator = new CarNameValidator();
        Cars cars = new Cars("I'm,bo,wook,hi,^^", carNameValidator);

        //when
        int randomNumber = 0;
        for (Car car : cars.getCars()) {
            car.judgeMove(randomNumber++);
        }
        Winner winner = new Winner(cars);
        int maxPosition = winner.getWinnerPosition();

        //then
        assertThat(maxPosition).isEqualTo(1);
        assertThat(winner.getWinners().get(0).getCarName()).isEqualTo("^^");
    }

}
