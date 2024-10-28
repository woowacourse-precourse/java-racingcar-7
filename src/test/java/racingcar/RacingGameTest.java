package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    private List<Car> cars;
    private Result result;
    private RacingGame racingGame;
    private GameConfiguration gameConfiguration;

    @BeforeEach
    void setUp() {
        String carNames = "pobi,haeyoon,hae";
        int gameCount = 5;

        InputHandler inputHandler = new InputHandler() {
            @Override
            public String inputCarNames() {
                return carNames;
            }
            @Override
            public int inputGameCount() {
                return gameCount;
            }
        };

        InputParser inputParser = new InputParser();
        gameConfiguration = new GameConfiguration(inputHandler, inputParser);
        cars = new ArrayList<>();
        result = new Result();
        racingGame = new RacingGame(gameConfiguration, cars, result);
    }

    @Test
    void 자동차_리스트_생성하기() {
        racingGame.run();
        assertEquals(3, cars.size());
        assertEquals("pobi", cars.get(0).carName());
        assertEquals("haeyoon", cars.get(1).carName());
        assertEquals("hae", cars.get(2).carName());
    }

    @Test
    void 게임_진행_테스트() {
        racingGame.run();
        assertTrue(cars.stream().allMatch(car -> car.currentPosition() >= 0));
    }

    @Test
    void 우승자_테스트() {
        racingGame.run();
        assertFalse(result.winnerList.isEmpty());
    }
}