package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.Racing;
import racingcar.strategy.ModeType;

public class RacingResultCalculatorTest {
    @Test
    void calculate_경주_우승자_기록_계산() {
        String input = "pobi,woni";
        Racing racing = new Racing(input);
        racing.setRacingCarMode(ModeType.RACING_CAR);

        List<Car> racingCars = racing.getRacingCars();
        //우승자 기록 계산을 위해 강제로 값 주입
        racingCars.get(0).setMoveDistance(2);
        racingCars.get(1).setMoveDistance(3);

        Integer result = RacingResultCalculator.calculateCarRacingWinnerRecord(racingCars);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void calculate_경주_우승자_생성() {
        String input = "pobi,woni";
        Racing racing = new Racing(input);
        racing.setRacingCarMode(ModeType.RACING_CAR);

        List<Car> racingCars = racing.getRacingCars();
        //우승자 기록 계산을 위해 강제로 값 주입
        racingCars.get(0).setMoveDistance(2);
        racingCars.get(1).setMoveDistance(3);

        List<String> result = RacingResultCalculator.calculateCarRacingWinner(racingCars, 3);

        assertThat(result.get(0)).isEqualTo("woni");
    }

    @Test
    void calculate_경주_우승자들_생성() {
        String input = "pobi,woni";
        Racing racing = new Racing(input);
        racing.setRacingCarMode(ModeType.RACING_CAR);

        List<Car> racingCars = racing.getRacingCars();
        //우승자 기록 계산을 위해 강제로 값 주입
        racingCars.get(0).setMoveDistance(3);
        racingCars.get(1).setMoveDistance(3);

        List<String> result = RacingResultCalculator.calculateCarRacingWinner(racingCars, 3);

        assertThat(result.get(0)).isEqualTo("pobi");
        assertThat(result.get(1)).isEqualTo("woni");
    }
}
