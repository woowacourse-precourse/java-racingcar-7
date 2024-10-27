package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    @DisplayName("playGame() 메서드를 테스트한다")
    void playGameTest() {
        List<Car> cars = Arrays.asList(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );
        int moveCount = 5;
        RacingGame racingGame = new RacingGame(cars, moveCount);
        racingGame.playGame();
    }
}
