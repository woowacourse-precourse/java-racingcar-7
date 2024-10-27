package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {
    @Test
    @DisplayName("우승자가 한명일 경우의 테스트")
    void showWinner() {
        //given
        RacingCarManager racingCarManager = new RacingCarManager();
        racingCarManager.newCar(new RacingCar("pobi"));
        racingCarManager.newCar(new RacingCar("minki"));

        //when
        racingCarManager.getRacingCarList().get(0).move();
        WinnerFinder winnerFinder = new WinnerFinder(racingCarManager);
        String winner = winnerFinder.getWinner();
        String expected = "pobi";
        //then
        assertThat(winner).isEqualTo(expected);
    }

    @Test
    @DisplayName("우승자가 여러명일 경우의 테스트")
    void showWinners() {
        //given
        RacingCarManager racingCarManager = new RacingCarManager();
        racingCarManager.newCar(new RacingCar("pobi"));
        racingCarManager.newCar(new RacingCar("minki"));
        racingCarManager.newCar(new RacingCar("tony"));

        //when
        racingCarManager.getRacingCarList().get(0).move();
        racingCarManager.getRacingCarList().get(1).move();
        racingCarManager.getRacingCarList().get(2).move();
        WinnerFinder winnerFinder = new WinnerFinder(racingCarManager);
        String winner = winnerFinder.getWinner();
        String expected = "pobi, minki, tony";
        //then
        assertThat(winner).isEqualTo(expected);
    }
}
