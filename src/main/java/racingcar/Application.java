package racingcar;

import racingcar.car.CarInputService;
import racingcar.car.CarInputValidator;
import racingcar.count.CountService;
import racingcar.count.CountValidator;
import racingcar.game.Game;
import racingcar.game.GameService;
import racingcar.game.GameView;

public class Application {
    public static void main(String[] args) {
        CarInputValidator carInputValidator = new CarInputValidator();
        CarInputService carInputService = new CarInputService(carInputValidator);

        CountValidator countValidator = new CountValidator();
        CountService countService = new CountService(countValidator);

        GameService gameService = new GameService();
        GameView gameView = new GameView(gameService);

        Game game = new Game(carInputService, countService, gameView);

        game.run();
    }
}
