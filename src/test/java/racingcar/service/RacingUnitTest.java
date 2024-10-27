package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.domain.Winner;
import racingcar.utils.RandomNumber;
import racingcar.validation.Validator;

public class RacingUnitTest {

    private Winner winner = new Winner();
    private RandomNumber randomNumber = new RandomNumber();
    private Validator validator = new Validator();
    private CarManager carManager;

    private RacingService racingService = new RacingService(winner, randomNumber, validator);

    @DisplayName("jenny가 2번 움직였을 경우, 최종 우승자는 jenny의 단독 우승이어야 한다")
    @Test
    void single_winner_test(){
        List<Car> cars = racingService.initCars("jenny,pobi,bibim");
        Car car1 = cars.get(0);
        car1.move(9);
        car1.move(9);

        String winners = racingService.getWinners();
        assertThat(winners).isEqualTo(car1.getName());
    }

    @DisplayName("jenny가 2번, bibim이 2번움직였을 경우, 최종 우승자는 jenny, bibim의 공동우승이어야 한다")
    @Test
    void joint_winner_test(){
        List<Car> cars = racingService.initCars("jenny,pobi,bibim");
        Car car1 = cars.get(0);
        Car car3 = cars.get(2);
        car1.move(9);
        car1.move(9);
        car3.move(9);
        car3.move(9);

        String expectedWinner = "jenny, bibim";

        String winners = racingService.getWinners();
        assertThat(winners).isEqualTo(expectedWinner);
    }
}
