package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        RacingGame racingGame = new RacingGame(cars, moveCount);
        racingGame.playGame();
    }
}
