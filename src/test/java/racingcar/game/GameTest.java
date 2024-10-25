package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarInputService;
import racingcar.car.CarInputValidator;
import racingcar.count.CountInputService;
import racingcar.count.CountInputValidator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {
    private Game game;
    private final ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        CarInputValidator carInputValidator = new CarInputValidator();
        CountInputValidator countInputValidator = new CountInputValidator();

        CarInputService carInputService = new CarInputService(carInputValidator) {
            @Override
            public List<Car> getCars() {
                return List.of(new Car("car1"), new Car("car2"), new Car("car3"));
            }
        };

        CountInputService countInputService = new CountInputService(countInputValidator) {
            @Override
            public String getAttemptCount() {
                return "10";
            }
        };

        RankService rankService = new RankService();

        GameView gameView = new GameView(rankService);
        game = new Game(carInputService, countInputService, gameView);

        System.setOut(new PrintStream(outputBuffer));
    }

    @DisplayName("게임을 실행한다.")
    @Test
    void runGame() {
        game.run();
        assertTrue(outputBuffer.toString().contains("실행 결과"));
    }
}
