package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingTest {

    @Test
    @DisplayName("getRaceWinners는 단독 우승자일때 단독 우승자만을 리스트에 담아 반환한다.")
    public void getRaceWinners_WhenUniqueWinner_ReturnCorrectly() {
        // given
        List<RacingCar> racingCars = List.of(
                new RacingCar("aaa", 3),
                new RacingCar("bbb", 2),
                new RacingCar("ccc", 1)
        );
        CarRacing carRacing = new CarRacing(racingCars, 0);

        RacingCar expectedWinner = racingCars.get(0);

        // when
        List<RacingCar> raceWinners = carRacing.getRaceWinners();

        // then
        Assertions.assertThat(raceWinners)
                .hasSize(1)
                .contains(expectedWinner);
    }

    @Test
    @DisplayName("getRaceWinners는 공동 우승자일때 공동 우승자 모두를 리스트에 담아 반환한다.")
    public void getRaceWinners_WhenMultipleWinners_ReturnCorrectly() {
        // given
        List<RacingCar> racingCars = List.of(
                new RacingCar("aaa", 3),
                new RacingCar("bbb", 3),
                new RacingCar("ccc", 3)
        );
        CarRacing carRacing = new CarRacing(racingCars, 0);

        // when
        List<RacingCar> raceWinners = carRacing.getRaceWinners();

        // then
        Assertions.assertThat(raceWinners)
                .hasSize(3)
                .contains(raceWinners.get(0))
                .contains(raceWinners.get(1))
                .contains(raceWinners.get(2));
    }
}
