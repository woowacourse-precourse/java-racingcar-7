package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class RacingGameTest {
    @Test
    @DisplayName("playGame()의 동작을 테스트한다")
    void playGameTest() {
        List<Car> cars = Arrays.asList(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );
        int moveCount = 10;
        WinnerManager winnerManager = new WinnerManager();
        RacingGame racingGame = new RacingGame(cars, moveCount, winnerManager);
        racingGame.playGame();
    }

    @Test
    @DisplayName("announceWinners()가 제대로 우승자를 출력하는지 확인한다")
    void announceWinnersTest() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        Car car4 = new Car("jason");
        car1.setDistance(10);
        car2.setDistance(4);
        car3.setDistance(7);
        car4.setDistance(10);

        List<Car> cars = Arrays.asList(car1, car2, car3, car4);
        WinnerManager winnerManager = new WinnerManager();
        int moveCount = 10;
        RacingGame racingGame = new RacingGame(cars, moveCount, winnerManager);
        String expectedWinners = "pobi, jason";

        racingGame.announceWinners();  // 출력 결과 확인
        List<Car> winners = winnerManager.determineWinners(cars);
        String winnerNames = winnerManager.getWinnerNames(winners);
        assertEquals(expectedWinners, winnerNames);
    }
}
