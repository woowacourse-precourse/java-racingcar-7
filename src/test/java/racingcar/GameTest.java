package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameTest {

    private Game game;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = List.of(new Car("도미"), new Car("코지"), new Car("포니"));
        game = new Game(cars, 5);
    }

    @Test
    void 우승자_테스트() {
        cars.get(0).advance();
        cars.get(2).advance();
        List<Car> winners = game.getWinners();

        assertEquals(2, winners.size());
        assertTrue(winners.contains(cars.get(0)));
        assertTrue(winners.contains(cars.get(2)));
    }

    @Test
    void 시도횟수_테스트() {
        assertEquals(5, game.getAttemptCount());
    }

}
